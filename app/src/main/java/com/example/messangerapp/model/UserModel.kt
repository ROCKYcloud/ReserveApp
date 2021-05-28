package com.example.messangerapp.model

data class UserModel(
    var firstName: String? = null,
    var lastName: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var password: String? = null,
    var passwordConfirm: String? = null
)