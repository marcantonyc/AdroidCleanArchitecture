package com.mvillarroel.cleanarchitecture.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.mvillarroel.cleanarchitecture.domain.model.Coin

// Option 1 ->
/* */
data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
/* */

// Option 2->
/* *
data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val is_active: Boolean,
    @SerializedName("is_new")
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
/* **/

asd
 */

fun CoinDto.toCoin() : Coin {
    return Coin (
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}