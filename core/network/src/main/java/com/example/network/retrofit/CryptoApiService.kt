package com.example.network.retrofit

import com.example.network.dto.CoinDetailDto
import com.example.network.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApiService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}