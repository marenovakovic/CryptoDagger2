package com.marko.cryptodagger2.dagger.modules

import com.marko.cryptodagger2.networking.CoinService
import com.marko.cryptodagger2.repositories.DataRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

	@Provides
	fun provideRepository(coinService: CoinService) = DataRepository(coinService)
}