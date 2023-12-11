package com.example.data.repository

import com.example.data.mapper.toDomain
import com.example.domain.repository.CoinRepository
import com.example.network.retrofit.CryptoApiService
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: CryptoApiService,
) : CoinRepository {
    override suspend fun getCoins() = apiService.getCoins().map {
        it.toDomain()
    }

    override suspend fun getCoin(id: String) = apiService.getCoinById(id).toDomain()
}