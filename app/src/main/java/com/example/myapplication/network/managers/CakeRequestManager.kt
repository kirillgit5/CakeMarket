package com.example.myapplication.network.managers

import com.example.myapplication.network.responses.cakes.getCakeInfo.GetCakeFullInfoResponse
import com.example.myapplication.network.responses.cakes.getCakes.GetCakesResponse
import retrofit2.Response

class CakeRequestManager(
    private val apiService: CakeManagerApi
    ) {
    suspend fun getCakes(): Response<GetCakesResponse> = apiService.getCakes()
    suspend fun getCakeInfo(id: Long): Response<GetCakeFullInfoResponse> = apiService.getCakeInfo(id)
}