package com.example.codehiveregistration.models
import  com.google.gson.annotations.SerializedName
data class RegistrationResponce(
    var  name:String,
   @SerializedName("phone_number") var  phoneNumber:String,
    var email:String,
    @SerializedName("date_of_birth") var  dateOfBirth:String,
    var  nationality:String,
    var password:String,
    var studentId:String


)
