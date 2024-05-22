package com.lamda.trendingmoviesapp.common.util

import android.content.Context
import com.lamda.trendingmoviesapp.common.util.Constants.CACHE_AGE
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class CacheControlInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response = chain.proceed(chain.request())
        val cacheControl = CacheControl.Builder()
            .maxAge(CACHE_AGE, TimeUnit.DAYS)
            .build()
        return response.newBuilder()
            .header("Cache-Control",cacheControl.toString())
            .build()
    }
}
