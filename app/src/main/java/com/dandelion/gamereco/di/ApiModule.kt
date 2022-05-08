package com.dandelion.gamereco.di

import com.dandelion.gamereco.data.api.IAuthApi
import com.dandelion.gamereco.data.api.IPlayerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private const val HTTP_SCHEME = "https://"
    private const val STEAM_API = "api.steampowered.com/"
    private const val TIMEOUT = 20L

    @Provides
    @Singleton
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder().apply {
            followRedirects(true)
            followSslRedirects(true)
            connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(httpLoggingInterceptor)
        }.build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("$HTTP_SCHEME$STEAM_API")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideAuthApi(retrofit: Retrofit): IAuthApi = retrofit.create(IAuthApi::class.java)

    @Provides
    fun providePlayerApi(retrofit: Retrofit): IPlayerApi = retrofit.create(IPlayerApi::class.java)
}
