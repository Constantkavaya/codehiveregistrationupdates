package com.example.codehiveregistration.models

import com.google.gson.annotations.SerializedName

data class LoginResponce(
    var message: String,
@SerializedName("access_token")
var accessToken: String,
@SerializedName("student_id")
var studentId: String,
var Email:String,
var Password:String)