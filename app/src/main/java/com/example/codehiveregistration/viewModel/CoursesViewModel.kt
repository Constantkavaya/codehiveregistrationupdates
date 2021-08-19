package com.example.codehiveregistration.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codehiveregistration.Courses
import com.example.codehiveregistration.repository.UserRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.models.CoursesRequest
import com.example.codehiveregistration.repository.CoursesRepisitory


class CoursesViewModel : ViewModel() {
    var coursesLiveData = MutableLiveData<List<Courses>>()
    var coursesFailedLiveData = MutableLiveData<String>()
    var coursesRepository =CoursesRepisitory()


    fun courses(){
        viewModelScope.launch{
            var accessToken = null
            var response = CoursesRepisitory.getcourses(accessToken)
            if (response.isSuccessful){
                coursesLiveData.postValue(response.body())
            }
            else{
                coursesFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}


