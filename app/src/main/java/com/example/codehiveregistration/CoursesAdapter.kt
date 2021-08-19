package com.example.codehiveregistration

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.models.EnrollmentRequest
//import com.example.codehiveregistration.viewModel.EnrolViewModel
import com.example.codehiveregistration.viewModel.EnrolViewModelViewModel

class CoursesAdapter(var courseResponseList: List<Courses>):RecyclerView.Adapter<CourseViewHolder>(){
        private lateinit var enrolViewModel: EnrolViewModelViewModel
        private lateinit var sharedPreferences: SharedPreferences
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {

            var itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_course_detail, parent, false)
            return CourseViewHolder(itemView)

        }

        override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
            var  currentCourse=courseResponseList.get(position)
            holder.tvcourseName.text=currentCourse.courseName
            holder.tvdescriptions.text=currentCourse.description
            holder.tvcodes.text=currentCourse.courseName
            holder.tvinstruct.text=currentCourse.instructor

            var currentResponseCourse=courseResponseList.get(position)
            holder.tvdateCreated.text=currentResponseCourse. tvdateCreated
            holder.tvdateUpdated.text=currentResponseCourse.tvdateUpdated
            holder.tvcreatedBy.text=currentResponseCourse.tvcreatedBy
            holder.tvupdatedBy.text=currentResponseCourse.tvupdatedBy
            holder.tvactive.text= currentResponseCourse.tvactive


            holder.btnEnrol.setOnClickListener {
                sharedPreferences=sharedPreferences
                var studentId=sharedPreferences.edit()
                var courseId = sharedPreferences.edit()
                var enrolmentRequest=EnrollmentRequest(
                    studentId = studentId.toString(),
                    courseId = courseId.toString()
                )
                enrolViewModel.getEnrolment(Constants.toString())
            }
        }

    override fun getItemCount(): Int {
        return courseResponseList .size
    }

}


    class  CourseViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var tvcourseName=itemView.findViewById<TextView>(R.id.tvcourseName)
        var tvdescriptions=itemView.findViewById<TextView>(R.id.tvdescription)
        var tvcodes=itemView.findViewById<TextView>(R.id.tvcode)
        var tvinstruct=itemView.findViewById<TextView>(R.id.tvinstructor)
        var tvdateCreated=itemView.findViewById<TextView>(R.id.tvdateCreated)
        var tvdateUpdated=itemView.findViewById<TextView>(R.id.tvdateUpdated)
        var tvcreatedBy=itemView.findViewById<TextView>(R.id.tvcreatedBy)
        var tvupdatedBy=itemView.findViewById<TextView>(R.id.tvupdatedBy)
        var tvactive=itemView.findViewById<TextView>(R.id.tvactive)
        var  btnEnrol=itemView.findViewById<TextView>(R.id.btnEnrol)

    }





