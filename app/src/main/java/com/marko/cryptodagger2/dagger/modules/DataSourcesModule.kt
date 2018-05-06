package com.marko.cryptodagger2.dagger.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.marko.data.database.CoinDatabase
import com.marko.data.datasource.LocalDataSourceImpl
import com.marko.data.datasource.RemoteDataSourceImpl
import com.marko.domain.datasources.LocalDataSource
import com.marko.domain.datasources.RemoteDataSource
import com.marko.domain.networking.CoinService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourcesModule {

	@Singleton
	@Provides
	fun provideCoinDatabase(context: Context) =
		Room.databaseBuilder(
				context,
				CoinDatabase::class.java,
				DATABASE_NAME
		)

	@Singleton
	@Provides
	fun provideRemoteDataSource(coinService: CoinService): RemoteDataSource =
			RemoteDataSourceImpl(coinService)

	@Singleton
	@Provides
	fun provideLocalDataService(coinDatabase: CoinDatabase): LocalDataSource =
			LocalDataSourceImpl(coinDatabase)

	companion object {
		private const val DATABASE_NAME = "coins"
	}
}