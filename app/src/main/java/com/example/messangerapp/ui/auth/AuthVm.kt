package com.example.messangerapp.ui.auth

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.messangerapp.R
import com.example.messangerapp.utils.eventEmitters.NavigationDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthVm @Inject constructor(
        private val navigationDispatcher: NavigationDispatcher,
) : ViewModel() {


    fun goSignUp() = navigationDispatcher.emit { it.navigate(R.id.singUpFragment) }

    fun goHome() = navigationDispatcher.emit { it.navigate(R.id.homeFragment) }

    fun goForgotPassword() = navigationDispatcher.emit { it.navigate(R.id.goForgotPassword) }
}