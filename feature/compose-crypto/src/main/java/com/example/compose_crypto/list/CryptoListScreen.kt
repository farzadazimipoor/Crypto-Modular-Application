package com.example.compose_crypto.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CryptoListScreen(
    viewModel: CryptoListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CryptoListScreen(uiState)
}

@Composable
fun CryptoListScreen(
    uiState: CryptoListScreenUiState,
) {
    when {
        uiState.isError -> Text(text = "Error")
        uiState.isLoading -> Text(text = "Loading")
        else -> {
            Text(text = "Data Loaded")
        }
    }
}