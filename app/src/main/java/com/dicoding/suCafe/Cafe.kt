package com.dicoding.sucafe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cafe(
    val name: String,
    val description: String,
    val photo: Int,
    val address: String,
    val price: String,
    val hour: String,
    val location: String
) : Parcelable