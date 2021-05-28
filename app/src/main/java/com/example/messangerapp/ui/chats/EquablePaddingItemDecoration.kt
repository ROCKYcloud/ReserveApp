package com.example.messangerapp.ui.chats

import android.graphics.Rect
import android.view.View
import androidx.annotation.Dimension
import androidx.recyclerview.widget.RecyclerView

class EquablePaddingItemDecoration (
        @Dimension private val padding: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) outRect.apply {
            top = padding
            left = padding
            right = padding
            bottom = padding
        }
        else outRect.apply {
            left = padding
            right = padding
            bottom = padding
        }
    }
}