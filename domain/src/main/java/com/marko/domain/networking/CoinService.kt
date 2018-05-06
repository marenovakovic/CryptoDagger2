package com.marko.domain.networking

import com.marko.domain.models.CoinData
import io.reactivex.Maybe
import retrofit2.http.GET

interface CoinService {
	@GET("listings")
	fun getAllCoins(): Maybe<CoinData>
}