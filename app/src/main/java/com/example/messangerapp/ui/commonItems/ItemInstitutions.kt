package com.example.messangerapp.ui.commonItems

import com.example.messangerapp.R
import android.view.View
import com.example.messangerapp.databinding.ItemCaffeBinding
import com.example.messangerapp.utils.OnTap
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem

class ItemInstitutions(
        private val onTap: OnTap
) : BindableItem<ItemCaffeBinding>() {

    override fun isSameAs(other: Item<*>): Boolean = other is ItemInstitutions


    override fun getLayout() = R.layout.item_caffe

    override fun initializeViewBinding(view: View) = ItemCaffeBinding.bind(view)

    override fun bind(viewBinding: ItemCaffeBinding, position: Int) {
        with(viewBinding.itemCaffe){
            setOnClickListener {
                onTap()
            }
        }
    }
}