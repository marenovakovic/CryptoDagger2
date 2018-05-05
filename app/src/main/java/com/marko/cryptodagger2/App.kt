package com.marko.cryptodagger2

import android.app.Application
import com.marko.cryptodagger2.dagger.components.AppComponent
import com.marko.cryptodagger2.dagger.components.DaggerAppComponent

class App: Application() {

	override fun onCreate() {
		super.onCreate()

		component = DaggerAppComponent.create()
	}

	companion object {
		lateinit var component: AppComponent
	}
}