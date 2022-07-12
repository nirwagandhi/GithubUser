package com.gandhi.githubuserapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    var username: String,
    var name: String,
    var Avatar: Int,
    var follower: String,
    var following: String,
    var company: String,
    var repository: String,
    var location: String,

) : Parcelable
