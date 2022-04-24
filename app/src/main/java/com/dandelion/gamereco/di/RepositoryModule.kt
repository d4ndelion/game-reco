package com.dandelion.gamereco.di

import com.dandelion.gamereco.data.api.IAuthApi
import com.dandelion.gamereco.domain.repositories.SteamAuthRepository
import com.dandelion.gamereco.domain.repositories.interfaces.ISteamAuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(api: IAuthApi): ISteamAuthRepository = SteamAuthRepository(api)
}
