package com.example.codehiveregistration

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.provider.Settings.Secure.getString
import android.provider.Settings.System.getString
import android.view.View.inflate
import android.widget.*
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.res.TypedArrayUtils.getString
import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInteface
import com.example.codehiveregistration.databinding.ActivityMainBinding
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponce
import com.example.codehiveregistration.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.nio.file.Paths.get

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var sharedPreferences = getSharedPreferences(Constants.SHAREDPREFS, MODE_PRIVATE)
//        registerStudent()
    }

    fun redirectUser() {
        var accessToken =
            SharedPreferences.getString(Constants.ACCESS_TOKEN, Constants.EMPTY_STRING)
        if (accessToken!!.isNotEmpty()) {
            ContextCompat.startActivity(Intent.(baseContext,LoginActivity::class))
        }

        fun onResume() {
            super.onResume()
            binding.btnregister.setOnClickListener {
                binding.etphonenumber.text.toString().isEmpty() ||
                        binding.etemail.text.toString().isEmpty() ||
                        binding.etpassword.text.toString().isEmpty()

                binding.etname.setError("Name required")
                binding.etdob.setError("Date of birth required")


            }

        }

        fun registerStudent() {

            var name = binding.etname.toString()
            var phoneNumber = binding.etphonenumber.text.toString()
            var email = binding.etemail.toString()
            var dateOfBirth = binding.etdob.text.toString()
            var password = binding.etpassword.text.toString()
            var nationality = binding.spnationality.toString()

            var regRequest = RegistrationRequest(
                name = name,
                phoneNumber = phoneNumber,
                password = password,
                nationality = nationality,
                dateOfBirth = dateOfBirth,
                email = email

            )

            userViewModel.registerUser(regRequest)
            userViewModel.registrationLiveData.observe(this, { regResponse ->
                if (!regResponse.studentId.isNullOrEmpty()) {
                    Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
                }
            })
            userViewModel.regFailedLiveData.observe(this, { error ->
                Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
            })

        }
    }
}

//    lateinit var Name: EditText
//    lateinit var dob: EditText
//    lateinit var etpassword: EditText
//    lateinit var spNationality: Spinner
//    lateinit var email: EditText
//    lateinit var phonenumber: EditText
//    lateinit var btnregister: Button
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        castViews()
//        clickregister()

//    fun castViews() {
//        Name = findViewById(R.id.etname)
//        dob = findViewById(R.id.etdob)
//         etpassword = findViewById(R.id.etpassword)
//         email = findViewById(R.id.etemail)
//         phonenumber = findViewById(R.id.etphonenumber)
//         btnregister = findViewById(R.id.btnregister)
//         spNationality = findViewById(R.id.spinner2)
//
//        val nationalities = arrayOf("kenyan", "rwandan", "southsudan", "ugandan")
//        var adapter =
//            ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationalities)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spNationality.adapter = adapter
//
//
//    }
//
//    fun clickregister() {
//        btnregister.setOnClickListener {
//
//            var name = Name.text.toString()
//            if (name.isEmpty()) {
//                error(true)
//                Name.setError("Name is required")
//            }
//            var doB = dob.text.toString()
//            if (doB.isEmpty()) {
//                error(true)
//                dob.setError("doB is required")
//            }
//            var phonenumbers = phonenumber.text.toString()
//            if (phonenumbers.isEmpty()) {
//                error(true)
//                phonenumber.setError("phonenumber is required")
//            }
//            var emails= email.text.toString()
//            if (emails.isEmpty()) {
//                error(true)
//                email.setError("phonenumber is required")
//            }
//            var nationality = spNationality.selectedItem.toString()
//            if (nationality.isEmpty()) {
//                spNationality.dropDownVerticalOffset
//            }
//            var password = etpassword.text.toString()
//            if (password.isEmpty()) {
//                error(true)
//                etpassword.setError ("password is required")
//            }
//            var RegistrationRequest = RegistrationRequest(
//                name = name,
//                phoneNumber = phonenumbers,
//                email =emails,
//                nationality = nationality,
//                dateOfBirth = doB,
//                password = password
//            )
//            val retrofit = ApiClient.buildApiClient(ApiInteface::class.java)
//            var request = retrofit.registerStudent(RegistrationRequest)
//            request.enqueue(object :Callback<RegistrationResponce>{
//                override fun onResponse(
//                    call: Call<RegistrationResponce>,
//                    response: Response<RegistrationResponce>
//                ) {
//                    if (response.isSuccessful)
//                      Toast.makeText(baseContext,"Registration Successful",Toast.LENGTH_LONG) .show()
//                    var intent=Intent(baseContext,loginActivity::class.java)
//                    startActivity(intent)
//                }
//
//                override fun onFailure(call: Call<RegistrationResponce>, t: Throwable) {
//                    Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//                }
//
//            })

//            Toast.makeText(baseContext, name, Toast.LENGTH_LONG).show()
//            val intent = Intent(baseContext, coursesActivity::class.java)
//            startActivity(intent)

//        }
//    }
//}


//data class CodehiveRegistration(var  name:String,
//                                var  dateofBirth:String,
//                                var nation:String,
//                                var  id:String,
//                                var email:String,
//                                var phonenumber:String)



