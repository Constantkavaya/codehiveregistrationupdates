package com.example.codehiveregistration.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.codehiveregistration.Courses
import com.example.codehiveregistration.models.CoursesRequest
import com.example.codehiveregistration.repository.CoursesRepisitory
import com.example.codehiveregistration.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class EnrollmentViewModel {
    var enrollmentLiveData = MutableLiveData<List<Courses>>()
    var enrollmentFailedLiveData = MutableLiveData<String>()
    var coursesRepository = CoursesRepisitory()


    fun getEnrollment(viewModelScope: Any) {
        viewModelScope.launch{
            var accessToken = null
            var Response = CoursesRepisitory.getEnrollment(accessToken)
            var response = UserRepository.enrollment(CoursesRequest)

            if (response.isSuccessful){
                enrollmentLiveData.postValue(response.body())
            }
            else{
                enrollmentFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}

private fun Any.launch(suspendFunction1: suspend CoroutineScope.() -> Unit) {

}
