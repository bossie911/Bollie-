package com.example.mdp_bollie.ui.course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mdp_bollie.R
import com.example.mdp_bollie.databinding.ItemCourseBinding

class CourseAdaptor(private val courses: List<Course>) : RecyclerView.Adapter<CourseAdaptor.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemCourseBinding.bind(itemView)


        fun databind(course: Course) {
            //binding.ivImage.setImageResource(R.drawable.)
            binding.tvCourseName.text = course.courseName
            binding.tvCourseAuthor.text = course.courseAuthor


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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = courses[position]
        holder.databind(item)
    }
}


