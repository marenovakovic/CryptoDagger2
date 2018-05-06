package com.marko.data.datasource

import com.marko.data.database.CoinDatabase
import com.marko.domain.datasources.LocalDataSource
import com.marko.domain.models.Coin
import io.reactivex.Completable
import io.reactivex.Single

class LocalDataSourceImpl(coinDatabase: CoinDatabase): LocalDataSource {

	private val coinDao = coinDatabase.coinDao()

	override fun getCoins(): Single<List<Coin>> =
			coinDao.getAllCoins()

	override fun saveCoins(coins: List<Coin>): Completable =
			coinDao.insertCoins(coins)
}