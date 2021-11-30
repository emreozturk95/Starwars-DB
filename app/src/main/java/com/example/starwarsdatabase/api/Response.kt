package com.example.starwarsdatabase.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(
    val message: String,
    val next: String,
    val previous: String,
    val results: List<Result>,
    val total_pages: Int,
    val total_records: Int
) : Parcelable