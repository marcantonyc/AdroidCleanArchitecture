package com.mvillarroel.cleanarchitecture.domain.usecase.get_coin

import com.mvillarroel.cleanarchitecture.common.Resource
import com.mvillarroel.cleanarchitecture.data.remote.dto.toCoin
import com.mvillarroel.cleanarchitecture.data.remote.dto.toCoinDetail
import com.mvillarroel.cleanarchitecture.domain.model.Coin
import com.mvillarroel.cleanarchitecture.domain.model.CoinDetail
import com.mvillarroel.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetail = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coinDetail))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error("couldn't reach server. Check your internet Connection"))
        }
    }
}