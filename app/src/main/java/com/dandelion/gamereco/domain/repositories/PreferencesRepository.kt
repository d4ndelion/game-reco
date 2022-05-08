package com.dandelion.gamereco.domain.repositories

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.dandelion.gamereco.domain.repositories.interfaces.IPreferencesRepository

private const val PREFS = "game_reco_preferences"
private const val STEAM_ID_KEY = "STEAM_ID_KEY"
private const val IS_LOGGED_KEY = "IS_LOGGED_KEY"

class PreferencesRepository(context: Context) : IPreferencesRepository {

    private val settings = EncryptedSharedPreferences.create(
        context,
        PREFS,
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override var steamId: String?
        get() = settings.getString(STEAM_ID_KEY, null)
        set(value) = settings.edit().putString(STEAM_ID_KEY, value).apply()

    override var isLoggedUser: Boolean
        get() = settings.getBoolean(IS_LOGGED_KEY, true)
        set(value) = settings.edit().putBoolean(IS_LOGGED_KEY, value).apply()

    override suspend fun clear() {
        settings.edit {
            remove(STEAM_ID_KEY)
        }
    }
}
