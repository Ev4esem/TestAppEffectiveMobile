package com.example.feature_main.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.EffectHandler
import com.example.base.collectAsResult
import com.example.feature_main.domain.model.main_model.Offer
import com.example.feature_main.domain.model.search_model.Town
import com.example.feature_main.domain.model.search_model.Util
import com.example.feature_main.domain.repo.MainRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository : MainRepository
) : ViewModel(), EffectHandler<MainEffect> {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    override val effectChannel : Channel<MainEffect> = Channel()

    init {
        getOfferList()
        getTownList()
        getUtils()
    }

    private fun getTownList() {

        val townList = mainRepository.getTownList()

        _uiState.update { currentState ->
            currentState.copy(
                townList = townList
            )
        }



    }

    private fun getUtils() {
        val utils = mainRepository.getUtils()

        _uiState.update { currentState ->
            currentState.copy(
                utils = utils
            )
        }

    }

    private fun getOfferList() {
        viewModelScope.launch {


            mainRepository.getOfferList().collectAsResult(
                onSuccess = { offerList ->

                    _uiState.update { currentState ->
                        currentState.copy(
                            offerList = offerList,
                            loading = false,
                            error = null
                        )

                    }

                },
                onError = { ex, message ->

                    _uiState.update { currentState ->
                        currentState.copy(
                            error = message,
                            loading = false
                        )

                    }
                    message?.let {
                        sendEffect(MainEffect.ShowToast(it))
                    }
                },
                onLoading = {
                    _uiState.update { currentState ->
                        currentState.copy(
                            loading = true,
                            error = null
                        )
                    }
                }
            )

        }
    }


}

sealed interface MainEffect {
    data class ShowToast(
        val message: String,
    ) : MainEffect
}

data class UiState(
    val offerList : List<Offer> = emptyList(),
    val error : String? = null,
    val utils : List<Util> = emptyList(),
    val townList : List<Town> = emptyList(),
    val loading : Boolean = false
)