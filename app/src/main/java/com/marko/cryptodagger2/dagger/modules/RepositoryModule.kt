package com.marko.cryptodagger2.dagger.modules

import com.marko.data.CoinRepositoryImpl
import com.marko.domain.datasources.LocalDataSource
import com.marko.domain.datasources.RemoteDataSource
import com.marko.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

	@Singleton
	@Provides
	fun provideCoinRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource): CoinRepository =
			CoinRepositoryImpl(remoteDataSource, localDataSource)
}