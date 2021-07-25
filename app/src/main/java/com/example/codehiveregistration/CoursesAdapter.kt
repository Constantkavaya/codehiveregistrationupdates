package com.example.codehiveregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

    class CoursesAdapter(var courseList: List<Courses>):RecyclerView.Adapter<CourseViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
            var itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_course_detail, parent, false)
            return CourseViewHolder(itemView)

        }

        override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
            var  currentCourse=courseList.get(position)
            holder.tvcourseName.text=currentCourse.courseName
            holder.tvdescriptions.text=currentCourse.description
            holder.tvcodes.text=currentCourse.courseName
            holder.tvinstruct.text=currentCourse.instructor


        }

        override fun getItemCount(): Int {
            return  courseList.size
        }
    }
    class  CourseViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var tvcourseName=itemView.findViewById<TextView>(R.id.tvcourseName)
        var tvdescriptions=itemView.findViewById<TextView>(R.id.tvdescription)
        var tvcodes=itemView.findViewById<TextView>(R.id.tvcode)
        var tvinstruct=itemView.findViewById<TextView>(R.id.tvinstructor)

    }





