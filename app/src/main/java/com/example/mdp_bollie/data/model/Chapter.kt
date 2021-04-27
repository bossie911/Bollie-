package com.example.mdp_bollie.data.model

data class Chapter(
    var chapterName: String = "",
    var chapterParagraphs: ArrayList<Paragraph> = arrayListOf(),
    var id: String? = null
)
