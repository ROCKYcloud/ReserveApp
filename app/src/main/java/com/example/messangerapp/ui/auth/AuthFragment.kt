package com.example.messangerapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.messangerapp.R
import com.example.messangerapp.databinding.FragmentAuthBinding
import com.example.messangerapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : Fragment(R.layout.fragment_auth) {
    private val binding by viewBinding(FragmentAuthBinding::bind)
    private val viewModel by viewModels<AuthVm>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       with(binding){
           tvCreateAccount.setOnClickListener{
              viewModel.goSignUp()
           }
           butSignIn.setOnClickListener {
               viewModel.goHome()
           }

           butForgotPassword.setOnClickListener {
               viewModel.goForgotPassword()
           }
       }
    }
}