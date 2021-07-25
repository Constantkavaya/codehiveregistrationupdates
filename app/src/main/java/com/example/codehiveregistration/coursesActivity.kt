package com.example.codehiveregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class coursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

            var rvcourses=findViewById<RecyclerView>(R.id.rvcourses)


            var  courseList= listOf(
                Courses("234","Android Development","John Awuor"),
                Courses("264","Web development","James Mwai"),
                Courses("225","pd","Kipchumba Murkomen"),


            )
            var coursesAdapter=CoursesAdapter(courseList)
            rvcourses.layoutManager= LinearLayoutManager(baseContext)
            rvcourses.adapter=coursesAdapter
}
}