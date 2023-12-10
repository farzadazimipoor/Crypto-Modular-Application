package com.example.compose_crypto.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CryptoListScreenUiState(isLoading = true))
    val uiState by lazy {
        loadData()
        _uiState.asStateFlow()
    }

    private fun loadData() {
        viewModelScope.launch {
            runCatching {
                getCoinsUseCase.invoke()
            }.onSuccess { coinList ->
                _uiState.update {
                    it.copy(isLoading = false, isError = false, coinList = coinList)
                }
            }.onFailure {
                _uiState.update {
                    it.copy(isLoading = false, isError = true)
                }
            }
        }
    }
}