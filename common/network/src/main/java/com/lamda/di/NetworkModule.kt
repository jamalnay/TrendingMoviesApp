package com.lamda.di

import android.content.Context
import com.lamda.util.BuildConfig
import com.lamda.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        cacheControlInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient().newBuilder()
            .cache(Cache(File(context.cacheDir, "http-cache"), 10L * 1024L * 1024L))
            .addNetworkInterceptor(cacheControlInterceptor)
            .also {
                if (BuildConfig.DEBUG) {
                    it.addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }
            }.build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCacheControl(): Interceptor {
        return Interceptor {
            val response = it.proceed(it.request())
            val cacheControl = CacheControl.Builder()
                .maxAge(com.lamda.util.Constants.CACHE_AGE, TimeUnit.DAYS)
                .build()
            response.newBuilder()
                .header("Cache-Control",cacheControl.toString())
                .build()
        }
    }

}