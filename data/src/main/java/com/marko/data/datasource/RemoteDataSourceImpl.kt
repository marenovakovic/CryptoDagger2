package com.marko.data.datasource

import com.marko.domain.datasources.RemoteDataSource
import com.marko.domain.models.CoinData
import com.marko.domain.networking.CoinService
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers

class RemoteDataSourceImpl(private val coinService: CoinService): RemoteDataSource {

	override fun getCoins(): Maybe<CoinData> =
			coinService
					.getAllCoins()
					.subscribeOn(Schedulers.io())
}