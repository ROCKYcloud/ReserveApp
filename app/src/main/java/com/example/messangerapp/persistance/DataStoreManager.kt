package com.example.messangerapp.persistance

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataStoreManager @Inject constructor(private val dataStore: DataStore<Preferences>) {

//    suspend fun setInfoDialogsDescriptions(infoDialogs: List<InfoDialogsResponse>) {
//        dataStore.edit { preferences ->
//            infoDialogs.forEach { infoDialog ->
//                val key = stringPreferencesKey(name = infoDialog.identifier)
//                preferences[key] = infoDialog.content
//            }
//        }
//    }

    suspend fun getInfoDialogDescription(key: Preferences.Key<String>): String =
        dataStore.data.first()[key] ?: ""

    suspend fun setTokens(accessToken: String, refreshToken: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.ACCESS_TOKEN] = "Bearer $accessToken"
            preferences[PreferencesKeys.REFRESH_TOKEN] = refreshToken
        }
    }

    suspend fun getAccessToken(): String =
        dataStore.data.first()[PreferencesKeys.ACCESS_TOKEN] ?: ""

    suspend fun getRefreshToken(): String? =
        dataStore.data.first()[PreferencesKeys.REFRESH_TOKEN]

    suspend fun clearData() {
        if (getAccessToken().isEmpty()) return
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.ACCESS_TOKEN] = ""
            preferences[PreferencesKeys.IS_NEW_USER] = true
        }
    }

    suspend fun setOnBoardingCompleted() {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.ON_BOARDING_COMPLETED] = true
        }
    }

    suspend fun getOnBoardingCompleted(): Boolean =
        dataStore.data.first()[PreferencesKeys.ON_BOARDING_COMPLETED] ?: false

    suspend fun setTermsOfUseCompleted() {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.TERMS_OF_USE_COMPLETED] = true
        }
    }

    suspend fun getTermsOfUseCompleted(): Boolean =
        dataStore.data.first()[PreferencesKeys.TERMS_OF_USE_COMPLETED] ?: false

    suspend fun setIsNewUser(isNewUser: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.IS_NEW_USER] = isNewUser
        }
    }

    suspend fun isNewUser(): Boolean =
        dataStore.data.first()[PreferencesKeys.IS_NEW_USER] ?: true

    suspend fun setFirebaseToken(deviceToken: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.DEVICE_TOKEN] = deviceToken
        }
    }

    suspend fun getFirebaseToken(): String =
        dataStore.data.first()[PreferencesKeys.DEVICE_TOKEN]!!

    object PreferencesKeys {
        val ACCESS_TOKEN = stringPreferencesKey(name = "accessToken")
        val REFRESH_TOKEN = stringPreferencesKey(name = "refreshToken")
        val AUTHORIZATION = stringPreferencesKey(name = "authorization")
        val FAMILY_MEMBERS = stringPreferencesKey(name = "familyMembers")
        val LOG_STATUSES_LIST = stringPreferencesKey(name = "logStatusesList")
        val NOTIFICATION_OPTIONS = stringPreferencesKey(name = "notificationOptions")
        val NOTIFICATIONS = stringPreferencesKey(name = "notifications")
        val PERMANENT_PLACES = stringPreferencesKey(name = "permanentPlaces")
        val SETTINGS = stringPreferencesKey(name = "settings")
        val SYMPTOMS = stringPreferencesKey(name = "symptoms")
        val VERIFICATION_CODE = stringPreferencesKey(name = "verificationCode")
        val VERIFIED_COVID = stringPreferencesKey(name = "verifiedCovid")
        val ON_BOARDING_COMPLETED = booleanPreferencesKey(name = "onBoardingCompleted")
        val TERMS_OF_USE_COMPLETED = booleanPreferencesKey(name = "termsOfUseCompleted")
        val IS_NEW_USER = booleanPreferencesKey(name = "isNewUser")
        val DEVICE_TOKEN = stringPreferencesKey(name = "deviceToken")
    }
}
