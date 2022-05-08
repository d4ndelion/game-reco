package com.dandelion.gamereco.domain.repositories.interfaces

interface IPreferencesRepository {
    var steamId: String?
    var isLoggedUser: Boolean
    suspend fun clear()
}
