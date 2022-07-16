package com.example.unsplash_penguinin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Urls(var thumb: String,var small:String) : Parcelable