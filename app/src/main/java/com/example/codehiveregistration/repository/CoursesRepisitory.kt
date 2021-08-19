package com.example.codehiveregistration.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.codehiveregistration.R
import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInteface
import com.example.codehiveregistration.models.CoursesRequest
import com.example.codehiveregistration.models.CoursesResponse
import com.example.codehiveregistration.models.LoginResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoursesRepisitory {

    lateinit var sessionManager: SessionManager
    var apiInterface = ApiClient.buildApiClient(ApiInteface::class.java)
    suspend fun getcourses(): Unit = withContext(Dispatchers.IO) {
        var response =
            apiInterface.getcourses(token = "Bearer ${sessionManager.fetchAuthentication()}")
        return@withContext response

    }

//    fun enrolment(accessToken: String): Any {
//        return enrolment(accessToken)
//    }

    class SessionManager(context: Context) {
        private var prefs: SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

        companion object {
            const val USER_TOKEN = "ACCESS_TOKEN"
        }

        fun saveAuthentication(token: String) {
            val editor = prefs.edit()
            editor.putString(USER_TOKEN, token)
            editor.apply()
        }

        fun fetchAuthentication(): String? {
            return prefs.getString(USER_TOKEN, null)
        }

    }
}
