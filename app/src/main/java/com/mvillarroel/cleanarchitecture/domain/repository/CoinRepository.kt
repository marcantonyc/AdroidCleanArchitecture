package com.mvillarroel.cleanarchitecture.domain.repository

import com.mvillarroel.cleanarchitecture.data.remote.dto.CoinDetailDto
import com.mvillarroel.cleanarchitecture.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}