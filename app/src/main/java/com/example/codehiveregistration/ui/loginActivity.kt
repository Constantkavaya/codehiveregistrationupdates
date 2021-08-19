package com.example.codehiveregistration

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInteface
import com.example.codehiveregistration.databinding.ActivityLoginBinding
import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponce
import com.example.codehiveregistration.ui.coursesActivity
import com.example.codehiveregistration.viewModel.LoginViewModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class  LoginActivity : AppCompatActivity() {
    val logInViewModel: LoginViewModel by viewModels()
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var btnlogin = findViewById<Button>(R.id.btnlogin)
        btnlogin.setOnClickListener {
            var intent = Intent(baseContext, coursesActivity::class.java)
            startActivity(intent)


        }
        var binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("CODEHIVE_REG_PREFS", Context.MODE_PRIVATE)
        binding.btnlogin.setOnClickListener {
            var logInRequest = LoginRequest(
                binding.etemmail.text.toString(),
                binding.etpasswrd.text.toString()
            )
            logInViewModel.logIn(logInRequest)

        }
    }

    override fun onResume() {
        super.onResume()
        binding.btnlogin.setOnLongClickListener {
            validateLogin()
        }
    }

    fun validateLogin(): Boolean {
        var email = binding.etemmail.text.toString()
        var password = binding.etpasswrd.text.toString()
        var error = false
        if (password.isBlank()||email.isBlank())


            logInViewModel.logInLiveData.observe(this, { logInResponse ->
                Toast.makeText(baseContext, logInResponse.message, Toast.LENGTH_LONG).show()

                var editor = logInResponse.accessToken
                sharedPreferences.edit().putString("ACCESS_TOKEN", logInResponse.accessToken)
                    .apply()
                var x = sharedPreferences.getString("ACCESS_TOKEN", "")
            })

        logInViewModel.logInFailedLiveData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
            var binding = null


        })
    }

}






//        setViews()
//        clickLogin()


//    fun setViews() {
//        emails = findViewById(R.id.etemmail)
//        etpasswords = findViewById(R.id.etpasswrd)
//        btnlogin = findViewById(R.id.btnlogin)
//    }
//
//    fun clickLogin() {
//        var error = false
//        btnlogin.setOnClickListener {
//            var etemail = emails.text.toString()
//            if (etemail.isEmpty())
//                emails.setError("Email required")
//
//            var etpassword = emails.text.toString()
//            if (etpassword.isEmpty())
//                emails.setError("Password required")
//
//        }
//        var logoinRequest = LoginRequest(
//            Email = "Email",
//            Password = "password"
//        )
//
//    }











