package com.lamda.trendingmoviesapp.common.di

import android.content.Context
import com.lamda.trendingmoviesapp.BuildConfig
import com.lamda.trendingmoviesapp.common.util.CacheControlInterceptor
import com.lamda.trendingmoviesapp.common.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
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
        return CacheControlInterceptor()
    }

}