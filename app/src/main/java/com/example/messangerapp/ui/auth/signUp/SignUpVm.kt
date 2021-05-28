package com.example.messangerapp.ui.auth.signUp

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.messangerapp.model.UserModel
import com.example.messangerapp.utils.eventEmitters.NavigationDispatcher
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpVm @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
    private val handle: SavedStateHandle
) : ViewModel() {
    private var auth = FirebaseAuth.getInstance()
    val user  = handle.getLiveData("user", UserModel())

    fun onMessageEntered(inputFirstName: String,inputLastName: String,inputPhone: String,inputEmail: String, inputPassword: String,inputPasswordConfirm: String) {
        user.value = user.value!!.apply {
            firstName = inputFirstName
            lastName = inputLastName
            phone = inputPhone
            email =inputEmail
            password = inputPassword
            passwordConfirm = inputPasswordConfirm
        }
    }

    fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("firstName", "user is added email: $email password: $password")
                    goBack()
                } else {
                    Log.d("firstName", "error")
                }
            }
    }
    private fun goBack() = navigationDispatcher.emit { it.navigateUp() }
}