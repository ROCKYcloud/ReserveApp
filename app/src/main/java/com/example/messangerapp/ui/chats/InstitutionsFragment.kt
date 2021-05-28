package com.example.messangerapp.ui.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messangerapp.R
import com.example.messangerapp.databinding.FragmentHomeBinding
import com.example.messangerapp.databinding.FragmentInstitutionsBinding
import com.example.messangerapp.ui.commonItems.ItemInstitutions
import com.example.messangerapp.utils.dp
import com.example.messangerapp.utils.viewBinding
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.insetter.applySystemWindowInsetsToPadding


@AndroidEntryPoint
class InstitutionsFragment : Fragment(R.layout.fragment_institutions) {
    private val binding by viewBinding(FragmentInstitutionsBinding::bind)
    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            recyclerView.applySystemWindowInsetsToPadding(bottom = true)
            recyclerView.apply {
                if (adapter != null) return@apply
                addItemDecoration(
                        EquablePaddingItemDecoration(
                                padding = 16.dp()
                        )
                )
                adapter = this@InstitutionsFragment.adapter
            }
        }
        assembleHome()
    }
    private fun assembleHome(){
        val uiList = mutableListOf<Group>()
        uiList += ItemInstitutions{

        }
        adapter.updateAsync(uiList)
    }
}