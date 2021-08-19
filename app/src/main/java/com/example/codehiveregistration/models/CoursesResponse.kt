package com.example.codehiveregistration.models

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses_name")var CoursesName:String,
    @SerializedName("courses_description")var Coursesdescription:String,
    var Instructor:String,
    var active: Boolean,
    @SerializedName("courses_code")var CoursesCode:String,
    @SerializedName("date_created") var date_created: String,
    @SerializedName("date_updated") var date_updated: String,
    @SerializedName("created_by") var created_by: String,
    @SerializedName("updated_by") var updated_by: String,

)
