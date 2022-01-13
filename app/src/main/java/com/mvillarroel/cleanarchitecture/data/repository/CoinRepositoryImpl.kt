package com.mvillarroel.cleanarchitecture.data.repository

import com.mvillarroel.cleanarchitecture.data.remote.CoinPaprikaApi
import com.mvillarroel.cleanarchitecture.data.remote.dto.CoinDetailDto
import com.mvillarroel.cleanarchitecture.data.remote.dto.CoinDto
import com.mvillarroel.cleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        var test = api.getCoins()
        var breakp ="break"
        return api.getCoins();
    }
    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}