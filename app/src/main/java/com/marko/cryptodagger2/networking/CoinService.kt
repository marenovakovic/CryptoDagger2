package com.marko.cryptodagger2.networking

import com.marko.cryptodagger2.models.CoinData
import io.reactivex.Maybe
import retrofit2.http.GET

interface CoinService {
	@GET("listings")
	fun getAllCoins(): Maybe<CoinData>
}