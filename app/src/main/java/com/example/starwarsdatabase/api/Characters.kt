package com.example.starwarsdatabase.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Characters(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<Result>? = null
) : Parcelable
