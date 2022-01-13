package com.mvillarroel.cleanarchitecture.presenter.coin_list

import com.mvillarroel.cleanarchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
