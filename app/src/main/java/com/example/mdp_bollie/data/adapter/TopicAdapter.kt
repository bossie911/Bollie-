package com.example.mdp_bollie.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mdp_bollie.R
import com.example.mdp_bollie.data.model.Course
import com.example.mdp_bollie.databinding.ItemTopicBinding

class TopicAdapter(private val topics: List<Course>) : RecyclerView.Adapter<TopicAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val binding = ItemTopicBinding.bind(itemView)

        fun databind(course: Course) {
            //binding.ivImage.setImageResource(R.drawable.)
            binding.nametv.text = course.courseName
            binding.authortv.text = course.courseAuthor
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_topic, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(topics[position])
    }
}