package com.example.messangerapp.utils.eventEmitters

import androidx.navigation.NavController
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

typealias NavigationCommand = (NavController) -> Unit

@ActivityRetainedScoped
class NavigationDispatcher @Inject constructor() {
    val navigationEmitter = Channel<NavigationCommand>(Channel.UNLIMITED)

    fun emit(navigationCommand: NavigationCommand) = navigationEmitter.offer(navigationCommand)
}
