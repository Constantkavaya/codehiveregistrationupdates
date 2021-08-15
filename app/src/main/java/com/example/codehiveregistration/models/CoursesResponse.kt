package com.example.codehiveregistration.models

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses_name")var CoursesName:String,
    @SerializedName("courses_description")var Coursesdescription:String,
    var Instructor:String,
    @SerializedName("courses_code")var CoursesCode:String
)
