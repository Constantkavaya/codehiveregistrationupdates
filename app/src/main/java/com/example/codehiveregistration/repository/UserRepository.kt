package com.example.codehiveregistration.repository

import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInteface
import com.example.codehiveregistration.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInteface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            Response<RegistrationResponce> = withContext(Dispatchers.IO){
        var response= apiInterface.registerStudent(registrationRequest)
        return@withContext response
    }
    suspend fun login(logInRequest: LoginRequest): Response<LoginResponce> =
        withContext(Dispatchers.IO){
            var response = apiInterface.logiStudent(logInRequest)
            return@withContext response
        }

}