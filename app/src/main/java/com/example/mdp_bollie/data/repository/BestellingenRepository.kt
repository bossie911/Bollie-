package com.example.mdp_bollie.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mdp_bollie.api.BolApi
import com.example.mdp_bollie.api.BolApiService
import com.example.mdp_bollie.data.model.Bestelling
import kotlinx.coroutines.withTimeout

class BestellingenRepository {
    private val bolApiService: BolApiService = BolApi.createApi()

    private val _bestellingen: MutableLiveData<Bestelling> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * Encapsulation :)
     */
    val trivia: LiveData<Bestelling>
        get() = _bestellingen

    /**
     * suspend function that calls a suspend function from the numbersApi call
     */
    suspend fun postToken()  {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                bolApiService.postToken()
            }

            _bestellingen.value = result
        } catch (error: Throwable) {
            throw TokenRefreshError("Unable to refresh trivia", error)
        }
    }

    class TokenRefreshError(message: String, cause: Throwable) : Throwable(message, cause)

}

