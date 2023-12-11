package com.example.data.repository

import com.example.domain.model.Coin
import com.example.domain.model.CoinDetail
import com.example.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor() : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return listOf(
            Coin(
                id = "BTC",
                isActive = true,
                name = "BitCoin",
                symbol = "B",
                rank = 1,
            )
        )
    }

    override suspend fun getCoin(id: String): CoinDetail {
        throw Exception()
    }
}