package com.example.codehiveregistration.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.codehiveregistration.R
import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInteface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EnrollmentRepisitory {
    lateinit var sessionManager: SessionManager
    var apiInterface = ApiClient.buildApiClient(ApiInteface::class.java)
    suspend fun getEnrollment(): Unit = withContext(Dispatchers.IO) {
        var response =
            apiInterface.getcourses(token = "Bearer ${sessionManager.fetchAuthentication()}")
        return@withContext response

    }

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
}