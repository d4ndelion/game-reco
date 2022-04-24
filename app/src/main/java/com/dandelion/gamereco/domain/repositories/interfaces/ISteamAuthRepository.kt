package com.dandelion.gamereco.domain.repositories.interfaces

import com.dandelion.gamereco.domain.models.VanityModel
import kotlinx.coroutines.flow.Flow

interface ISteamAuthRepository {
    suspend fun getVanity(nickname: String): Flow<VanityModel>
}
