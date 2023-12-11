package com.example.data.mapper

import com.example.domain.model.Coin
import com.example.domain.model.CoinDetail
import com.example.domain.model.TeamMember
import com.example.network.dto.CoinDetailDto
import com.example.network.dto.CoinDto
import com.example.network.dto.TeamMemberDto

fun CoinDetailDto.toDomain() = CoinDetail(
    coinId = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isActive = isActive,
    tags = tags.map { it.name },
    team = team.map { it.toDomain() }
)

fun CoinDto.toDomain() = Coin(
    id = id,
    isActive = isActive,
    name = name,
    rank = rank,
    symbol = symbol,
)

fun TeamMemberDto.toDomain() = TeamMember(
    id = id,
    name = name,
    position = position,
)
