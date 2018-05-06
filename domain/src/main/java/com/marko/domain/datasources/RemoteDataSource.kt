package com.marko.domain.datasources

import com.marko.domain.models.CoinData
import io.reactivex.Maybe

interface RemoteDataSource {
	fun getCoins(): Maybe<CoinData>
}