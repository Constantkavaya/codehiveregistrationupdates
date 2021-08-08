package com.example.codehiveregistration.repository

import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInteface
import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponce
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Response

class UserRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInteface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            Call<RegistrationResponce> = withContext(Dispatchers.IO){
        var response = apiInterface.registerStudent(registrationRequest)
        return@withContext response
    }

    suspend fun login(logInRequest: LoginRequest): Call<LoginResponce> =
        withContext(Dispatchers.IO){
            var response = apiInterface.logiStudent(logInRequest)
            return@withContext response
        }
}