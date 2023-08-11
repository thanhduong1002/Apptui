package com.example.apptui.model

import androidx.annotation.DrawableRes

data class Idol (
    @DrawableRes val imageResourceIdol: Int,
    val name: String,
    val age: String,
    val country: String
)