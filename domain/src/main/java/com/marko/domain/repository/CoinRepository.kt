package com.marko.domain.repository

import com.marko.domain.models.Coin
import io.reactivex.Completable
import io.reactivex.Single

interface CoinRepository {
	fun getCoins(): Single<List<Coin>>
	fun getCoinsFromDatabase(): Single<List<Coin>>
	fun saveCoins(coins: List<Coin>): Completable
}