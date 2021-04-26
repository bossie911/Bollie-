package com.example.mdp_bollie.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mdp_bollie.R
import com.example.mdp_bollie.data.model.Course
import com.example.mdp_bollie.databinding.ItemCourseBinding

class CourseAdapter(private val courses: List<Course>) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemCourseBinding.bind(itemView)

        fun databind(course: Course) {
            //binding.ivImage.setImageResource(R.drawable.)
            binding.tvCourseName.text = course.courseName
            //binding.tvCourseAuthor.text = course.courseAuthor
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    fun setCourses(courses: List<Course>){
        this.courses
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(courses[position])
    }
}