object Versions {
	// Kotlin
	const val kotlin_version = "1.2.41"

	// Gradle
	const val gradle_plugin = "3.1.2"

	// Support Library
	const val support_library = "27.1.1"
	const val constraint_layout = "1.1.0"

	// Anko
	const val anko = "0.10.5"

	// Architecture Components
	const val architecture_components = "1.1.1"
	const val room = "1.0.0"

	// Dagger 2
	const val dagger_2 = "2.14.1"

	// Config
	const val compile_sdk = 27
	const val target_sdk = 27
	const val min_sdk = 18

	const val gson = "2.1.0"

	// OkHttp
	const val ok_http = "3.10.0"
	const val ok_http_logger = "3.9.0"

	// Retrofit
	const val retrofit = "2.4.0"
	const val retrofit_rxjava_adapter = "1.0.0"

	// RxJava
	const val rxjava = "2.1.9"
	const val rxandroid = "2.0.2"
	const val rxkotlin = "2.2.0"

	// Testing
	const val junit = "4.12"
	const val support_test_runner = "1.0.2"
	const val espresso_core = "3.0.2"
}

object Deps {
	// Kotlin and Gradle
	const val gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle_plugin}"
	const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
	const val kotlin_lib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
	const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"

	// Support Library
	const val app_compat = "com.android.support:appcompat-v7:${Versions.support_library}"
	const val recycler_view = "com.android.support:recyclerview-v7:${Versions.support_library}"
	const val card_view = "com.android.support:cardview-v7:${Versions.support_library}"
	const val fab = "com.android.support:design:${Versions.support_library}"

	// Constraint Layout
	const val constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.constraint_layout}"

	// Anko
	const val anko_commons = "org.jetbrains.anko:anko-commons:${Versions.anko}"

	// Architecture Components
	const val livedata_and_viewmodel = "android.arch.lifecycle:extensions:${Versions.architecture_components}"
	const val room = "android.arch.persistence.room:runtime:${Versions.room}"
	const val room_compiler = "android.arch.persistence.room:compiler:${Versions.room}"
	const val room_rxjava = "android.arch.persistence.room:rxjava2:${Versions.room}"

	// Dagger 2
	const val dagger_2 = "com.google.dagger:dagger:${Versions.dagger_2}"
	const val dagger_2_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger_2}"

	// Gson
	const val gson = "com.squareup.retrofit2:converter-gson:${Versions.gson}"

	// OkHttp
	const val ok_http = "com.squareup.okhttp3:okhttp:${Versions.ok_http}"
	const val ok_http_logger = "com.squareup.okhttp3:logging-interceptor:${Versions.ok_http}"

	// Retrofit
	const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
	const val rxjava_retrofit_adapter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.retrofit_rxjava_adapter}"

	// RxJava
	const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
	const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
	const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"

	// Testing
	const val junit = "junit:junit:${Versions.junit}"
	const val support_test_runner = "com.android.support.test:runner:${Versions.support_test_runner}"
	const val espresso_core = "com.android.support.test.espresso:espresso-core:${Versions.espresso_core}"
}