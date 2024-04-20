package com.example.feature_select_country.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.EffectHandler
import com.example.base.collectAsResult
import com.example.data.model.select_country_model.Option
import com.example.data.model.select_country_model.TicketsOffer
import com.example.data.repo.SelectCountryRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SelectCountryViewModel(
    private val selectCountryRepository : com.example.data.repo.SelectCountryRepository
) : ViewModel(), EffectHandler<SelectCountryEffect> {

    private val _uiState = MutableStateFlow(SelectCountryUiState())
    val uiState = _uiState.asStateFlow()

    override val effectChannel : Channel<SelectCountryEffect> = Channel()


    init {
        getTickets()
        getOptions()
    }

    private fun getOptions() {

        val options = selectCountryRepository.getOptions()
        _uiState.update { currentState ->
            currentState.copy(
                options = options
            )
        }

    }

    private fun getTickets() {
        viewModelScope.launch {


            selectCountryRepository.getCountryList().collectAsResult(
                onSuccess = { tickets ->

                    _uiState.update { currentState ->
                        currentState.copy(
                            tickets = tickets,
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
                        sendEffect(SelectCountryEffect.ShowToast(it))
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

sealed interface SelectCountryEffect {
    data class ShowToast(
        val message: String,
    ) : SelectCountryEffect
}


data class SelectCountryUiState(
    val options : List<com.example.data.model.select_country_model.Option> = emptyList(),
    val loading : Boolean = false,
    val error : String? = null,
    val tickets : List<com.example.data.model.select_country_model.TicketsOffer> = emptyList()
)
