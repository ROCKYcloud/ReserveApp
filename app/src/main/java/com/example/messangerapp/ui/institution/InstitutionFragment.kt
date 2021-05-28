package com.example.messangerapp.ui.institution

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.messangerapp.R
import com.example.messangerapp.databinding.FragmentInstitutionBinding
import com.example.messangerapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InstitutionFragment : Fragment(R.layout.fragment_institution) {
    private val binding by viewBinding(FragmentInstitutionBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

        }
    }
}