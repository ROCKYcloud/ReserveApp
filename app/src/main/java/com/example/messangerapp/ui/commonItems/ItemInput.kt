package com.example.messangerapp.ui.commonItems

import android.text.InputType
import android.view.Gravity
import android.view.View
import com.example.messangerapp.R
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.doOnPreDraw
import androidx.core.widget.doAfterTextChanged
import com.example.messangerapp.databinding.ItemInputBinding
import com.example.messangerapp.utils.INSET_INPUT
import com.example.messangerapp.utils.OnTyped
import com.example.messangerapp.utils.addDrawableEnd
import com.example.messangerapp.utils.onImeDoneListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

typealias OnFocus = (editText: TextInputEditText) -> Unit

class InputItem(
    private val hintText: String,
    private val drawableIcon: Int? = null,
    private val imeType: Int,
    private val imeOption: Int,
    private var errorText: String? = null,
    private val inputValue: String? = null,
    private val endIcon: Int = TextInputLayout.END_ICON_NONE,
    private var onTyped: OnTyped,
    private var onFocus: OnFocus,
    private var minimumLines: Int = 0
) : Item<InputItem.InputViewHolder>() {

    init {
        extras[INSET_INPUT] = INSET_INPUT
    }

    override fun isSameAs(other: Item<*>): Boolean = other is InputItem

    override fun hasSameContentAs(other: Item<*>): Boolean = other is InputItem &&
            other.hintText == hintText &&
            other.inputValue == inputValue &&
            other.errorText == errorText

    override fun getLayout() = R.layout.item_input

    override fun createViewHolder(itemView: View) = InputViewHolder(itemView, onTyped)

    override fun bind(viewHolder: InputViewHolder, position: Int) = with(viewHolder.binding) {
        with(input) {
            setText(inputValue)
            setSelection(inputValue?.length ?: 0)
            doOnPreDraw { onFocus(this) }
            hint = hintText
            inputType = InputType.TYPE_CLASS_TEXT or imeType
            imeOptions = imeOption
           // typeface = ResourcesCompat.getFont(context, R.font.rubik_regular)
            addDrawableEnd(drawableIcon)
            if (minimumLines > 0) {
                minLines = minimumLines
                gravity = Gravity.TOP
            } else {
                isSingleLine = true
                gravity = Gravity.CENTER_VERTICAL
            }
        }

        with(tilInput) {
            endIconMode = endIcon
            isErrorEnabled = errorText != null
            error = errorText
        }
    }

    class InputViewHolder(view: View, onTyped: OnTyped) : GroupieViewHolder(view) {
        val binding = ItemInputBinding.bind(view)

        init {
            binding.input.onImeDoneListener {
                onTyped(binding.input.text.toString())
            }
            binding.input.doAfterTextChanged { userInput ->
                binding.tilInput.error = null
                binding.tilInput.isErrorEnabled = false
                onTyped(userInput.toString())
            }
        }
    }
}
