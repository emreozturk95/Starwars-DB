package com.example.starwarsdatabase.api.extentions

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.makeToast(@StringRes message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}