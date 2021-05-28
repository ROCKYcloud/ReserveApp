package com.example.messangerapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.messangerapp.R
import com.example.messangerapp.utils.eventEmitters.NavigationDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVm @Inject constructor(
        private val navigationDispatcher: NavigationDispatcher,
) : ViewModel() {

    fun goInstitution() = navigationDispatcher.emit { it.navigate(R.id.action_homeFragment_to_institutionFragment) }
}