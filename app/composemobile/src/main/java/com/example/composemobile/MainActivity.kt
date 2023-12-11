package com.example.composemobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose_crypto.list.CryptoListScreen
import com.example.composemobile.ui.theme.CryptoModularApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoModularApplicationTheme {
                CryptoListScreen()
            }
        }
    }
}