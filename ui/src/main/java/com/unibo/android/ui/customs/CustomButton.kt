package com.unibo.android.ui.customs

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

// Questo codice dice ad Android: "Il CustomButton esiste ed è un bottone standard"
class CustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.buttonStyle
) : AppCompatButton(context, attrs, defStyleAttr)