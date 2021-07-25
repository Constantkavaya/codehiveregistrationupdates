package com.example.codehiveregistration.api
import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponce
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponce
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInteface {
    @POST("/students/register")
    fun  registerStudent( @Body registrationRequest: RegistrationRequest): Call<RegistrationResponce>

   @POST ("/students/login")
   fun logiStudent(@Body loginRequest: LoginRequest):Call<LoginResponce>

}