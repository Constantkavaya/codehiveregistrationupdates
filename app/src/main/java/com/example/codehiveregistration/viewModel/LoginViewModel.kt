package com.example.codehiveregistration.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponce
import com.example.codehiveregistration.repository.UserRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class LoginViewModel : ViewModel() {
    var logInLiveData = MutableLiveData<LoginResponce>()
    var logInFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun logIn(logInRequest: LoginRequest){
        viewModelScope.launch{
            var response = userRepository.login(logInRequest)
            if (response.isSuccessful){
                logInLiveData.postValue(response.body())
            }
            else{
                logInFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}

