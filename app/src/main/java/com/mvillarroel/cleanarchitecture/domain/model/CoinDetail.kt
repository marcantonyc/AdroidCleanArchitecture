package com.mvillarroel.cleanarchitecture.domain.model

import com.mvillarroel.cleanarchitecture.data.remote.dto.Team

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,
    val tags: List<String>,
    val team: List<Team>
)
