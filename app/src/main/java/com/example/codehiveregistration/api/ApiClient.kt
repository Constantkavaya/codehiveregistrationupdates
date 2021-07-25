package com.example.codehiveregistration.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.233.243.129")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildApiClient( apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }
}
