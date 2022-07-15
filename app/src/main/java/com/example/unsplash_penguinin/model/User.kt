package com.example.unsplash_penguinin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(var id: String, var name: String, var portfolio_url: String) : Parcelable

