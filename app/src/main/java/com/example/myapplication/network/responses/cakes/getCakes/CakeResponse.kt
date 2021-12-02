package com.example.myapplication.network.responses.cakes.getCakes

import java.math.BigDecimal

data class CakeResponse(
    val id: Long?,
    val name: String,
    val calories: BigDecimal?,
    val image: String,
    val price: BigDecimal?,
    val weight: BigDecimal?
)
