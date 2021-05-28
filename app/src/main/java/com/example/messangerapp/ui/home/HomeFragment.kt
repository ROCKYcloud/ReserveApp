package com.example.messangerapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.example.messangerapp.R
import com.example.messangerapp.databinding.ButtonBinding
import com.example.messangerapp.databinding.FragmentHomeBinding
import com.example.messangerapp.databinding.ItemCaffeBinding
import com.example.messangerapp.ui.chats.EquablePaddingItemDecoration
import com.example.messangerapp.ui.commonItems.ItemInstitutions
import com.example.messangerapp.utils.dp
import com.example.messangerapp.utils.viewBinding
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.insetter.applySystemWindowInsetsToPadding

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val viewModel by viewModels<HomeVm>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            recyclerView.applySystemWindowInsetsToPadding(bottom = true)
            recyclerView.apply {
                assembleHome()
                addItemDecoration(
                    EquablePaddingItemDecoration(
                        padding = 16.dp()
                    )
                )
                if (adapter != null) return@apply
                adapter = this@HomeFragment.adapter
            }
            assembleHome()
        }
    }
    private fun assembleHome(){
        val uiList = mutableListOf<Group>()
        uiList += ItemInstitutions(){
viewModel.goInstitution()
        }
        uiList += ItemInstitutions(){

        }
        uiList += ItemInstitutions(){

        }
        uiList += ItemInstitutions(){

        }
        uiList += ItemInstitutions(){

        }
        uiList += ItemInstitutions(){

        }
        uiList += ItemInstitutions(){

        }
        uiList += ItemInstitutions(){

        }
        uiList += ItemInstitutions(){

        }
        adapter.updateAsync(uiList)
    }


}

class Button(
) : BindableItem<ButtonBinding>() {

    override fun isSameAs(other: Item<*>): Boolean = other is Button

    override fun getLayout() = R.layout.button

    override fun initializeViewBinding(view: View) = ButtonBinding.bind(view)

    override fun bind(viewBinding: ButtonBinding, position: Int) {
    }
}