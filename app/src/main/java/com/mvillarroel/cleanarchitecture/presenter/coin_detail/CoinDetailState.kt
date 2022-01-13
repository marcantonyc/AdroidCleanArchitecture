package com.mvillarroel.cleanarchitecture.presenter.coin_detail

import com.mvillarroel.cleanarchitecture.domain.model.Coin
import com.mvillarroel.cleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
