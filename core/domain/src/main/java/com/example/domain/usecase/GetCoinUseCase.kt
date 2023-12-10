package com.example.domain.usecase

import com.example.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository,
) {
    suspend operator fun invoke(id: String) = coinRepository.getCoin(id)
}
