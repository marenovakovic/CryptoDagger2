package com.marko.cryptodagger2.networking

import okhttp3.Interceptor
import okhttp3.Response

class NetInterceptor: Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val request = chain.request().newBuilder()

		request.addHeader("Content-Type", "application/json")

		return chain.proceed(request.build())
	}
}