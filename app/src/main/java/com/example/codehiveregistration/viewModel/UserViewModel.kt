package com.example.codehiveregistration.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponce
import com.example.codehiveregistration.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    var registrationLiveData = MutableLiveData<RegistrationResponce>()
    var regFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun registerStudent(registrationRequest: RegistrationRequest){
        viewModelScope.launch{
            var response = userRepository.registerStudent(RegistrationRequest())
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())
            }
            else{
                regFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    
}