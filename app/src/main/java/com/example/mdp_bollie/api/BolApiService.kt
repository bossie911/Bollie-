package com.example.mdp_bollie.api

import com.example.mdp_bollie.data.model.Bestelling
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface BolApiService {
    // The GET method needed to retrieve a random number trivia.
  //  @Headers("Username: 7f3e2f43-f388-41a7-b613-a52383b2a5d0","Password: BVNKsln5djaGhSG3FfXKN9FiYGpikTbzvLoUuqtWirsRkmoEouGAvDkHUaoZ7VxfBS9fYBxdHQgp2eghDIcYrw")
    @POST("/token?grant_type=client_credentials")
    suspend fun postToken(): Bestelling

}