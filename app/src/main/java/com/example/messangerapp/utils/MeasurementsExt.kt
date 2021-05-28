package com.example.messangerapp.utils

import android.content.res.Resources

fun Float.dp(): Float = this * density + 0.5f

fun Int.dp(): Int = (this * density + 0.5f).toInt()

fun Int.sp(): Float = this * scaledDensity + 0.5f

val density: Float
    get() = Resources.getSystem().displayMetrics.density

val scaledDensity: Float
    get() = Resources.getSystem().displayMetrics.scaledDensity
