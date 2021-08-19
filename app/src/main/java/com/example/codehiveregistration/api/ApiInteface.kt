package com.example.codehiveregistration.api
import com.example.codehiveregistration.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInteface {
    @POST("/students/register")
    suspend fun  registerStudent( @Body registrationRequest: RegistrationRequest): Response<RegistrationResponce>

   @POST ("/students/login")
  suspend fun logiStudent(@Body loginRequest: LoginRequest):Response<LoginResponce>

    @POST ("/students/courses")
    suspend fun coursesList(@Body loginRequest: LoginRequest):Response<LoginResponce>

    @GET("/courses")
    suspend fun getcourses(@Header("Authorization")token:String)

}

suspend fun enrolment(accessToken:String):Response<EnrollmentResponse> =
    withContext(Dispatchers.IO){
        var enrol=ApiInteface.getEnrollment(accessToken)
        return@withContext enrol
    }
