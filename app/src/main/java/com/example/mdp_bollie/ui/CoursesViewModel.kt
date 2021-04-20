package com.example.mdp_bollie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mdp_bollie.data.model.Course
import com.example.mdp_bollie.data.model.NODE_COURSES
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Exception

class CoursesViewModel: ViewModel() {

    private val dbCourses = FirebaseDatabase.getInstance().getReference(NODE_COURSES)

    private val _courses = MutableLiveData<List<Course>>()
    val courses: LiveData<List<Course>>
        get() = _courses

    fun fetchCourses(){
        dbCourses.addListenerForSingleValueEvent(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    val courses = mutableListOf<Course>()
                    for(coursesSnapshot in snapshot.children){
                        val course = coursesSnapshot.getValue(Course::class.java)
                        course?.id = coursesSnapshot.key
                        course?.let {courses.add(it)}
                    }
                    _courses.value = courses
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}