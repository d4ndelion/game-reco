package com.dandelion.gamereco.domain.repositories

import com.dandelion.gamereco.data.api.IAuthApi
import com.dandelion.gamereco.data.response.toVanityModel
import com.dandelion.gamereco.domain.models.VanityModel
import com.dandelion.gamereco.domain.repositories.interfaces.ISteamAuthRepository
import com.dandelion.gamereco.utils.STEAM_API_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SteamAuthRepository(private val authApi: IAuthApi) : ISteamAuthRepository {

    override suspend fun getVanity(nickname: String): Flow<VanityModel> = flow {
        val vanity = authApi.resolveVanityUrl(STEAM_API_KEY, nickname).toVanityModel()
        emit(vanity)
    }
}
