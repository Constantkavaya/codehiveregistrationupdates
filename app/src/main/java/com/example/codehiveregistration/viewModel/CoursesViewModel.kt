package com.example.codehiveregistration.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codehiveregistration.Courses
import com.example.codehiveregistration.repository.UserRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope


class CoursesViewModel : ViewModel() {
    var coursesLiveData = MutableLiveData<List<Courses>>()
    var coursesFailedLiveData = MutableLiveData<String>()
    var coursesRepository =UserRepository()


    fun coursesList(){
        viewModelScope.launch{
            var response = UserRepository.courses()
            if (response.isSuccessful){
                coursesLiveData.postValue(response.body())
            }
            else{
                coursesFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}


