package com.example.mdp_bollie.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mdp_bollie.data.repository.BestellingenRepository
import kotlinx.coroutines.launch

class BestellingViewModel(application: Application) : AndroidViewModel(application) {
    private val bestellingenRepository = BestellingenRepository()

    /**
     * This property points direct to the LiveData in the repository, that value
     * get's updated when user clicks FAB. This happens through the refreshNumber() in this class :)
     */
    val trivia = bestellingenRepository.trivia

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * errorText can be observed from Activity for error showing
     * Encapsulation :)
     */
    val errorText: LiveData<String>
        get() = _errorText

    /**
     * The viewModelScope is bound to Dispatchers.Main and will automatically be cancelled when the ViewModel is cleared.
     * Extension method of lifecycle-viewmodel-ktx library
     */
    fun getToken() {
        viewModelScope.launch {
            try {
                //the triviaRepository sets it's own livedata property
                //our own trivia property points to this one
                bestellingenRepository.postToken()
            } catch (error: BestellingenRepository.TokenRefreshError) {
                _errorText.value = error.message
                Log.e("token error", error.cause.toString())
            }
        }
    }
}
