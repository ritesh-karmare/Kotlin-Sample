package com.example.navigation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserData(val name: String, val age: Int, val email: String) : Parcelable