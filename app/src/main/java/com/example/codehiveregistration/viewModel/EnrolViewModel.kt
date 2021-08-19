package com.example.codehiveregistration.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.codehiveregistration.models.EnrollmentResponse
import com.example.codehiveregistration.repository.CoursesRepisitory

class EnrolViewModelViewModel(){
    var enrolLiveData= MutableLiveData<EnrollmentResponse>()
    var enrolFailedLiveData= MutableLiveData<String>()
    var courseRepository=CoursesRepisitory()

    fun getEnrolment(accessToken: String){
        var viewModelScope = null
        viewModelScope.launch {
            var response=courseRepository.enrolment(accessToken)
            if (response.isSuccessful){
                enrolLiveData.postValue(response.body())
            }
            else{
                enrolFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
