package com.example.mdp_bollie.data.model

data class Course(
    //var imageId: String,
    var courseName: String = "",
    var courseChapters: ArrayList<Chapter> = arrayListOf(),
    var id: String? = null
    //var progress: Int
)
