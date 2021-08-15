package com.example.codehiveregistration.api
import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponce
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponce
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInteface {
    @POST("/students/register")
    suspend fun  registerStudent( @Body registrationRequest: RegistrationRequest): Response<RegistrationResponce>

   @POST ("/students/login")
  suspend fun logiStudent(@Body loginRequest: LoginRequest):Response<LoginResponce>

    @POST ("/students/courses")
    suspend fun coursesList(@Body loginRequest: LoginRequest):Response<LoginResponce>

}