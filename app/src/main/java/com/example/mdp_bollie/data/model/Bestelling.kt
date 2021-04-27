package com.example.mdp_bollie.data.model

import com.google.gson.annotations.SerializedName

data class Bestelling(
    @SerializedName("access_token") var access_token: String,
    @SerializedName("bestelNummer") var text: String,
    @SerializedName("naam") var number: String,
    @SerializedName("adress") var found: String

)