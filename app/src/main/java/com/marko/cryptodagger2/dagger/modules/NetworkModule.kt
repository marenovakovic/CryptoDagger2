package com.marko.cryptodagger2.dagger.modules

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.marko.domain.networking.CoinService
import com.marko.cryptodagger2.networking.NetInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

	private val BASE_URL = "https://api.coinmarketcap.com/v2/"

	@Provides
	@Singleton
	fun provideNetInterceptor() = NetInterceptor()

	@Provides
	@Singleton
	fun provideOkHttpClient(netInterceptor: NetInterceptor): OkHttpClient {
		val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

		val clientBuilder = OkHttpClient.Builder()
				.addInterceptor(netInterceptor)
				.addInterceptor(logger)

		return clientBuilder.build()
	}

	@Provides
	fun provideCoinService(okHttpClient: OkHttpClient, netInterceptor: NetInterceptor): CoinService {
		val coinClient = okHttpClient.newBuilder()
				.addInterceptor(netInterceptor)
				.build()

		val retrofit = Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(coinClient)
				.build()

		return retrofit.create(CoinService::class.java)
	}
}