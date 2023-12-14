package com.example.domain.util

import kotlinx.coroutines.flow.Flow

interface NetworkMonitor {
    fun isOnline(): Flow<Boolean>
}