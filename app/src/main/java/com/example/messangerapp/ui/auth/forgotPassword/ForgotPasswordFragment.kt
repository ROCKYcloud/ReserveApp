package com.example.messangerapp.ui.auth.forgotPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messangerapp.R
import com.example.messangerapp.databinding.FragmentAuthBinding
import com.example.messangerapp.databinding.FragmentForgotPasswordBinding
import com.example.messangerapp.utils.viewBinding


class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {

    private val binding by viewBinding(FragmentForgotPasswordBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

        }
    }

}