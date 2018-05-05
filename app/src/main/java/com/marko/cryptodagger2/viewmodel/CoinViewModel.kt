package com.marko.cryptodagger2.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.marko.cryptodagger2.App
import com.marko.cryptodagger2.models.Coin
import com.marko.cryptodagger2.repositories.DataRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class CoinViewModel: ViewModel() {

	private val disposables = CompositeDisposable()

	private val coinsStream = MutableLiveData<List<Coin>>()
	private val errorStream = MutableLiveData<String>()

	@Inject
	lateinit var repository: DataRepository

	init {
		App.component.inject(this)
	}

	fun fetch() {
		addSubscription(
				repository.getCoins()
						.observeOn(AndroidSchedulers.mainThread())
						.subscribe(
								{
									coinsStream.value = it.data
								},
								{
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