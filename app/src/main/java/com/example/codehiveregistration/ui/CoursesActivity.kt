package com.example.codehiveregistration.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.Constants
import com.example.codehiveregistration.Constants.Companion.SHAREDPREFS
import com.example.codehiveregistration.Courses
import com.example.codehiveregistration.CoursesAdapter
import com.example.codehiveregistration.R
import com.example.codehiveregistration.databinding.ActivityCoursesBinding
import com.example.codehiveregistration.databinding.ActivityLoginBinding
import com.example.codehiveregistration.viewModel.CoursesViewModel

class coursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoursesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_courses)
        var sharedPreferences = getSharedPreferences(Constants, SHAREDPREFS, context, MODE_PRIVATE)

    }

    override fun onResume() {
        super.onResume()
        if (accessToken!!.isNotEmpty()) {
            CoursesViewModel.getcourses(accessToken)

        }
        CoursesViewModel.coursesLiveData.observe(this, { coursesList ->
            Toast.makeText(baseContext,"${coursesList.size}courses Fetched",Toast.LENGTH_LONG).apply()

        })
        CoursesViewModel.errorLiveData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })

            var rvcourses=findViewById<RecyclerView>(R.id.rvcourses)


            var  courseList= listOf(
                Courses("234","Android Development","John Awuor"),
                Courses("264","Web development","James Mwai"),
                Courses("225","pd","Kipchumba Murkomen"),


            )
            var coursesAdapter= CoursesAdapter(courseList)
            rvcourses.layoutManager= LinearLayoutManager(baseContext)
            rvcourses.adapter=coursesAdapter
}
}