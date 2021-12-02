package com.example.myapplication.network.managers

import com.example.myapplication.network.responses.cakes.getCakeInfo.GetCakeFullInfoResponse
import com.example.myapplication.network.responses.cakes.getCakes.GetCakesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CakeManagerApi {
    @GET("cakes")
    suspend fun getCakes(): Response<GetCakesResponse>

    @GET("getCakeInfo/{id}")
    suspend fun getCakeInfo(@Path("id") id : Long) : Response<GetCakeFullInfoResponse>
}