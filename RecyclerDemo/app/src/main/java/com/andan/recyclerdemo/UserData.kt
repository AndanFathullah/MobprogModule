package com.andan.recyclerdemo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData (
    var photo: Int,
    var username: String,
    var name: String,
    var company: String,
    var location: String,
    var follower: String,
    var following: String,
        ):Parcelable