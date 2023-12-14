package com.example.compose_crypto.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCoinsUseCase
import com.example.domain.util.AirplaneModeChangeProvider
import com.example.domain.util.NetworkMonitor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val networkMonitor: NetworkMonitor,
    private val airplaneModeChangeProvider: AirplaneModeChangeProvider,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CryptoListScreenUiState(isLoading = true))
    val uiState by lazy {
        initObservers()
        loadData()
        _uiState.asStateFlow()
    }

    private fun loadData() {
        viewModelScope.launch {
            runCatching {
                getCoinsUseCase.invoke()
            }.onSuccess { coinList ->
                _uiState.update {
                    it.copy(isLoading = false, errorState = null, coinList = coinList)
                }
            }.onFailure {
                _uiState.update { it.copy(isLoading = false, errorState = ErrorState.Other()) }
            }
        }
    }

    private fun initObservers() {
        viewModelScope.launch {
            airplaneModeChangeProvider.isChanged().collectLatest { enabled ->
                if (enabled) {
                    _uiState.update { it.copy(errorState = ErrorState.AirPlainMode) }
                }
            }

            networkMonitor.isOnline().collectLatest { connected ->
                if (!connected) {
                    _uiState.update { it.copy(errorState = ErrorState.NotConnected) }
                } else {
                    onRetry()
                }
            }
        }
    }

    fun onRetry() {
        setLoadingState()
        loadData()
    }

    private fun setLoadingState() = _uiState.update { it.copy(isLoading = true, errorState = null) }
}