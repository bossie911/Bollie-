package com.example.mdp_bollie.ui.login

data class User (
    var firstname: String? = null,
    var lastname: String? = null,
    var username: String? = null,
    var companyname: String? = null,
    var email: String? = null
) {
    //Empty constructor for the object method.
    //constructor() : this("", "","","","")
}
