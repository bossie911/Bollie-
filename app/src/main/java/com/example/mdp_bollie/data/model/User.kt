package com.example.mdp_bollie.data.model

data class User(
    var userId: String? = null,
    var first_name: String? = null,
    var last_name: String? = null,
    var following: Array<Course>? = null

)
