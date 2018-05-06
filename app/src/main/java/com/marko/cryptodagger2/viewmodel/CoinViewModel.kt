package com.marko.cryptodagger2.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.marko.cryptodagger2.App
import com.marko.cryptodagger2.view.state.MainActivityState
import com.marko.domain.models.Coin
import com.marko.domain.repository.CoinRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class CoinViewModel: ViewModel() {

	private val disposables = CompositeDisposable()

	private val coinsStream = MutableLiveData<List<Coin>>()
	private val stateStream = MutableLiveData<Int>()
	private val errorStream = MutableLiveData<String>()

	@Inject
	lateinit var repository: CoinRepository

	init {
		App.component.inject(this)
	}

	fun fetch() {
		stateStream.value = MainActivityState.LOADING
		addSubscription(
				repository.getCoins()
						.observeOn(AndroidSchedulers.mainThread())
						.subscribe(
								{
									coinsStream.value = it
									stateStream.value = MainActivityState.DONE_LOADING
									disposables.add(
											repository.saveCoins(it)
													.observeOn(AndroidSchedulers.mainThread())
													.subscribe(
															{
																errorStream.value = "Coins saved in database"
																stateStream.value = MainActivityState.DONE_LOADING
															},
															{
																errorStream.value = it.message
																stateStream.value = MainActivityState.ERROR
															}
													)
									)
								},
								{
									disposables.add(
											repository.getCoinsFromDatabase()
													.observeOn(AndroidSchedulers.mainThread())
													.subscribe(
															{
																coinsStream.value = it
																stateStream.value = MainActivityState.DONE_LOADING
															},
															{
																errorStream.value = it.message
																stateStream.value = MainActivityState.ERROR
															}
													)
									)
									errorStream.value =
											when (it) {
												is SocketTimeoutException -> "Internet too slow"
												is IOException -> "No internet connection"
												else -> "Unknown error"
											}
								}
						)
		)
	}

	fun getCoinStream() = coinsStream

	fun getStateStream() = stateStream

	fun getErrorStream() = errorStream

	override fun onCleared() {
		super.onCleared()

		if (!disposables.isDisposed) disposables.dispose()
	}

	@Synchronized
	private fun addSubscription(disposable: Disposable?) =
			disposable?.let {
				disposables.add(it)
			}
}