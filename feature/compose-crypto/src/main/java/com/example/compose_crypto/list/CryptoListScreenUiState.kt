package com.example.compose_crypto.list

import com.example.domain.model.Coin

data class CryptoListScreenUiState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = emptyList(),
    val isError: Boolean = false,
)