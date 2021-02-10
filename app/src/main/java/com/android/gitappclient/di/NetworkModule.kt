package com.android.gitappclient.di

import com.android.gitappclient.api.ApiService
import com.android.gitappclient.utility.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {
    @Provides
    fun provideBaseUrl(): String = AppConstant.BASE_URL

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .callTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).build()

    @Provides
    fun providesGSONConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    fun providesRetrofit(
        baseUrl: String,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(converterFactory)
            .client(okHttpClient).build()

    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService=retrofit.create(ApiService::class.java)


}