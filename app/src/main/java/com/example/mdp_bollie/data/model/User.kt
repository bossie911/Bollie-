package com.example.mdp_bollie.data.model

import com.example.mdp_bollie.ui.course.Course

data class User(
    var id: String? = null,
    var first_name: String? = null,
    var last_name: String? = null,
    var following: Array<Course>? = null

)
