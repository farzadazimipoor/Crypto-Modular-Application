package com.example.domain.util

import kotlinx.coroutines.flow.Flow

interface AirplaneModeChangeProvider {
    fun isChanged(): Flow<Boolean>
}