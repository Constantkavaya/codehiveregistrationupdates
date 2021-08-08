package com.example.codehiveregistration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.*
import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInteface
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponce
import com.example.codehiveregistration.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityMainBinding : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()

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
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.btnRegister.setOnClickListener {
            var regRequest = RegistrationRequest(
                name = binding.etname.toString(),
                phoneNumber = binding.etphonenumber.text.toString(),
                email = binding.etemail.toString(),
                dateOfBirth = binding.etdob.text.toString(),
                password = binding.etpassword.text.toString()
            )
            userViewModel.registerStudent(regRequest)
        }
        userViewModel.registrationLiveData.observe(this,{ regResponse ->
            if (!regResponse.studentId.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regFailedLiveData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }
}

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



