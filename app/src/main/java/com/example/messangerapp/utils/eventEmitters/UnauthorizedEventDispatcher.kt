package com.example.messangerapp.utils.eventEmitters

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

@ActivityRetainedScoped
class UnauthorizedEventDispatcher @Inject constructor() {
    val unauthorizedEventEmitter = Channel<Boolean>()

    suspend fun requestDeuthorization() {
        unauthorizedEventEmitter.send(true)
    }
}
