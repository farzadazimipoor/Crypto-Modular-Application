package com.example.domain.repository

import com.example.domain.model.Coin
import com.example.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoin(id: String): CoinDetail
}
