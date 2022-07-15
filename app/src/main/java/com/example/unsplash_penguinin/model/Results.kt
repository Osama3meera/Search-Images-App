package com.example.unsplash_penguinin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Results(
    var id: String,
    var description: String,
    var alt_description: String,
    var urls: Urls,
    var user: User
) : Parcelable