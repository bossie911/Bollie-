package com.example.mdp_bollie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mdp_bollie.data.model.Course
import com.example.mdp_bollie.data.model.NODE_USERS
import com.example.mdp_bollie.data.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UsersViewModel : ViewModel() {
    private val dbCourses = FirebaseDatabase.getInstance().getReference(NODE_USERS)

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    fun fetchCourses() {
        dbCourses.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val users = mutableListOf<User>()
                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(User::class.java)
                        user?.userId = userSnapshot.key
                        user?.let { users.add(it) }
                    }
                    _users.value = users
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}