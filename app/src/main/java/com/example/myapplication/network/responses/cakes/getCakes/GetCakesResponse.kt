package com.example.myapplication.network.responses.cakes.getCakes

import com.example.myapplication.network.responses.cakes.getCakes.CakeResponse

data class GetCakesResponse(
    val cake_list: List<CakeResponse>
)
