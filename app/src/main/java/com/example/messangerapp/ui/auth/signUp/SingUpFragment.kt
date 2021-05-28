package com.example.messangerapp.ui.auth.signUp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.messangerapp.R
import com.example.messangerapp.databinding.FragmentSingUpBinding
import com.example.messangerapp.model.UserModel
import com.example.messangerapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SingUpFragment : Fragment(R.layout.fragment_sing_up) {

    private val binding by viewBinding(FragmentSingUpBinding::bind)
    private val viewModel by viewModels<SignUpVm>()
//    private val pickImage = 100
//    private var imageUri: Uri? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signUp()
    }

    private fun signUp() = with(binding) {
        var user = UserModel()
        tilFirstName.doAfterTextChanged {
            user.firstName = it.toString()
        }
        tilLastName.doAfterTextChanged {
            user.lastName = it.toString()
        }
        tilPhone.doAfterTextChanged {
            user.phone = it.toString()
        }
        tilEmail.doAfterTextChanged {
            user.email = it.toString()
        }
        tilPassword.doAfterTextChanged {
            user.password = it.toString()
        }
        tilConfirm.doAfterTextChanged {
            user.passwordConfirm = it.toString()
        }
//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.onMessageEntered(
//                inputFirstName = user.firstName.toString(),
//                inputLastName = user.lastName.toString(),
//                inputPhone = user.phone.toString(),
//                inputPassword = user.password.toString(),
//                inputPasswordConfirm = user.passwordConfirm.toString(),
//                inputEmail = user.email.toString()
//            )
//        }
        butSignUp.setOnClickListener {
                viewModel.signUp(email = "view@gmail.com",password = "password")
            }
    }
}