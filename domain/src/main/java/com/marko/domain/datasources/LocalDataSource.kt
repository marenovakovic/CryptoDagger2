package com.marko.domain.datasources

import com.marko.domain.models.Coin
import io.reactivex.Completable
import io.reactivex.Single

interface LocalDataSource {
	fun getCoins(): Single<List<Coin>>
	fun saveCoins(coins: List<Coin>): Completable
}