package com.example.codehiveregistration.api
import com.example.codehiveregistration.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInteface {
    @POST("/students/register")
    suspend fun  registerStudent( @Body registrationRequest: RegistrationRequest): Response<RegistrationResponce>

   @POST ("/students/login")
  suspend fun logiStudent(@Body loginRequest: LoginRequest):Response<LoginResponce>

    @POST ("/students/courses")
    suspend fun coursesList(@Body loginRequest: LoginRequest):Response<LoginResponce>

}