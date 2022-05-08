package com.dandelion.gamereco.di

import android.content.Context
import com.dandelion.gamereco.data.api.IAuthApi
import com.dandelion.gamereco.data.api.IPlayerApi
import com.dandelion.gamereco.domain.repositories.PlayerRepository
import com.dandelion.gamereco.domain.repositories.PreferencesRepository
import com.dandelion.gamereco.domain.repositories.SteamAuthRepository
import com.dandelion.gamereco.domain.repositories.interfaces.IPlayerRepository
import com.dandelion.gamereco.domain.repositories.interfaces.IPreferencesRepository
import com.dandelion.gamereco.domain.repositories.interfaces.ISteamAuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providePreferencesRepository(@ApplicationContext context: Context): IPreferencesRepository =
        PreferencesRepository(context)

    @Provides
    fun provideAuthRepository(api: IAuthApi): ISteamAuthRepository = SteamAuthRepository(api)

    @Provides
    fun providePlayerRepository(api: IPlayerApi): IPlayerRepository = PlayerRepository(api)
}
