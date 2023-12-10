package com.example.domain.usecase

import com.example.domain.model.Coin
import com.example.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository,
) {
    suspend operator fun invoke(): List<Coin> = coinRepository.getCoins()
}
