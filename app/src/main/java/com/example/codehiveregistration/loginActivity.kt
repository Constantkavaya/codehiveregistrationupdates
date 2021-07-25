package com.example.codehiveregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInteface
import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponce
import com.example.codehiveregistration.models.RegistrationResponce
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class loginActivity(loginRequest: LoginRequest) : AppCompatActivity() {
    lateinit var emails: EditText
    lateinit var etpasswords: EditText
    lateinit var btnlogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setViews()
        clickLogin()
    }

    fun setViews() {
        emails = findViewById(R.id.etemmail)
        etpasswords = findViewById(R.id.etpasswrd)
        btnlogin = findViewById(R.id.btnlogin)
    }

    fun clickLogin() {
        var error = false
        btnlogin.setOnClickListener {
            var etemail = emails.text.toString()
            if (etemail.isEmpty())
                emails.setError("Email required")

            var etpassword = emails.text.toString()
            if (etpassword.isEmpty())
                emails.setError("Password required")

        }
        var logoinRequest = LoginRequest(
            Email = "Email",
            Password = "password"
        )

    }

    var retrofit = ApiClient.buildApiClient(ApiInteface::class.java)
    var request = retrofit.logiStudent(loginRequest).enqueue(object : Callback<LoginResponce> {
        override fun onResponse(call: Call<LoginResponce>, response: Response<LoginResponce>) {
            if (response.isSuccessful) {
                Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
            } else {
                try {
                    val error = JSONObject(response.errorBody()!!.string())
                    Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
                        .show()
                } catch (e: Exception) {
                    Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }


        override fun onFailure(call: Call<LoginResponce>, t: Throwable) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
        }


    })
    }


data class ApiError(var errors: List<String>)











