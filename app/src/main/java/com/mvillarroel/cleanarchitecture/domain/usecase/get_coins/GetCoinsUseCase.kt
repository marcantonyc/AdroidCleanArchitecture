package com.mvillarroel.cleanarchitecture.domain.usecase.get_coins

import com.mvillarroel.cleanarchitecture.common.Resource
import com.mvillarroel.cleanarchitecture.data.remote.dto.toCoin
import com.mvillarroel.cleanarchitecture.domain.model.Coin
import com.mvillarroel.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error ocurred"))
        } catch (e: IOException){
            emit(Resource.Error("couldn't reach server. Check your internet Connection"))
        }
    }
}