package com.example.mdp_bollie.api

import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BolApi {
    companion object {
        // The base url off the api.
        private const val baseUrl = "https://login.bol.com/"
        private var credentials: String? = null



        fun createApi(): BolApiService {

            // Create an OkHttpClient to be able to make a log of the network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(
                    BasicAuthInterceptor(
                        "7f3e2f43-f388-41a7-b613-a52383b2a5d0",
                        "BVNKsln5djaGhSG3FfXKN9FiYGpikTbzvLoUuqtWirsRkmoEouGAvDkHUaoZ7VxfBS9fYBxdHQgp2eghDIcYrw"
                    )
                )
                .build()

            // Create the Retrofit instance
            val bolApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Return the Retrofit NumbersApiService
            return bolApi.create(BolApiService::class.java)
        }
    }
}
