package com.example.starwarsdatabase.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class Properties(
    val birth_year: String,
    val created: String,
    val edited: String,
    val eye_color: String,
    val gender: String,
    val hair_color: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val skin_color: String,
    val url: String
) : Parcelable