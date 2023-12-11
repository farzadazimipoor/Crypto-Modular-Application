package com.example.compose_crypto.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CryptoListScreen(
    viewModel: CryptoListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CryptoListScreen(uiState, viewModel::onRetry)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoListScreen(
    uiState: CryptoListScreenUiState,
    onRetry: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Crypto Currencies") },
                colors = topAppBarColors(
                    titleContentColor = Color.White,
                    containerColor = Color.Blue,
                )
            )
        }
    ) { innerPadding ->
        when {
            uiState.isError -> ErrorView(onRetry)
            uiState.isLoading -> Loading()
            else -> ShowData(innerPadding, uiState)
        }
    }
}

@Composable
private fun ShowData(
    innerPadding: PaddingValues,
    uiState: CryptoListScreenUiState,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(uiState.coinList) {
            CryptoListItem(model = it)
        }
    }
}

@Composable
private fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorView(onRetry: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Error!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "An error occurred",
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = onRetry
            ) {
                Text(text = "Retry")
            }
        }
    }
}