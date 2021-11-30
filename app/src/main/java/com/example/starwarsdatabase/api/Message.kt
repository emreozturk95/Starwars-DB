package com.example.starwarsdatabase.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Message(
    val message: String,
    val result: Result
):Parcelable

