package com.marko.cryptodagger2.dagger.components

import com.marko.cryptodagger2.dagger.modules.AppModule
import com.marko.cryptodagger2.dagger.modules.NetworkModule
import com.marko.cryptodagger2.dagger.modules.RepositoryModule
import com.marko.cryptodagger2.dagger.modules.DataSourcesModule
import com.marko.cryptodagger2.viewmodel.CoinViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
	(NetworkModule::class),
	(DataSourcesModule::class),
	(AppModule::class),
	(RepositoryModule::class)
])
interface AppComponent {
	fun inject(viewModel: CoinViewModel)
}