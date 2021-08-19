package com.example.codehiveregistration.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codehiveregistration.Courses
import com.example.codehiveregistration.repository.UserRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.models.CoursesRequest


class CoursesViewModel : ViewModel() {
    var coursesLiveData = MutableLiveData<List<Courses>>()
    var coursesFailedLiveData = MutableLiveData<String>()
    var coursesRepository =UserRepository()


    fun courses(){
        viewModelScope.launch{
            var response = UserRepository.courses(CoursesRequest)
            if (response.isSuccessful){
                coursesLiveData.postValue(response.body())
            }
            else{
                coursesFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}


