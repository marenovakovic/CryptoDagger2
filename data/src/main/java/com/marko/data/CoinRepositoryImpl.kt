package com.marko.data

import com.marko.domain.datasources.LocalDataSource
import com.marko.domain.datasources.RemoteDataSource
import com.marko.domain.models.Coin
import com.marko.domain.repository.CoinRepository
import io.reactivex.Completable
import io.reactivex.Single

class CoinRepositoryImpl(private val remoteDataSource: RemoteDataSource,
						 private val localDataSource: LocalDataSource): CoinRepository {

	override fun getCoins(): Single<List<Coin>> =
			remoteDataSource
					.getCoins()
					.flatMapSingle {
						Single.just(it.data)
					}

	override fun getCoinsFromDatabase(): Single<List<Coin>> =
			localDataSource.getCoins()

	override fun saveCoins(coins: List<Coin>) =
		localDataSource.saveCoins(coins)
}