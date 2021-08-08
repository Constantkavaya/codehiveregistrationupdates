package com.example.codehiveregistration.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codehiveregistration.Courses

class CoursesViewModel : ViewModel() {
    var coursesLiveData = MutableLiveData<List<Courses>>()
    var coursesFailedLiveData = MutableLiveData<String>()
    var coursesRepository =CoursesRepository()


    fun coursesList(){
        var viewModelScope = null
        viewModelScope.launch{
            var response = coursesRepository.courses()
            if (response.isSuccessful){
                coursesLiveData.postValue(response.body())
            }
            else{
                coursesFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}


