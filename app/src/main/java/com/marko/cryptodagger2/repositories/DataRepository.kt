package com.marko.cryptodagger2.repositories

import com.marko.cryptodagger2.networking.CoinService
import io.reactivex.schedulers.Schedulers

class DataRepository(private val coinService: CoinService) {

	fun getCoins() = coinService.getAllCoins()
			.subscribeOn(Schedulers.io())
}