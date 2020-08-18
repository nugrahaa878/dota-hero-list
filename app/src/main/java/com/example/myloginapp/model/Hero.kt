package com.example.myloginapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero (
    var name: String,
    var role: String,
    var photo: Int
): Parcelable