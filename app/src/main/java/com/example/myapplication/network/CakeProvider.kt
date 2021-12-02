package com.example.myapplication.network

import com.example.myapplication.model.Cake
import com.example.myapplication.model.CakeFullInfo
import com.example.myapplication.network.responses.cakes.getCakeInfo.GetCakeFullInfoResponse
import com.example.myapplication.network.responses.cakes.getCakes.CakeResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.Exception

class CakeProvider(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val requestManager = NetworkLayer.cakeRequestManager

    suspend fun getCakes(): List<Cake> = withContext(defaultDispatcher) {
        var cakeList: List<CakeResponse> = listOf()

        try {
            val response = requestManager.getCakes()

            if (response.isSuccessful) {
                cakeList = response.body()?.cake_list ?: listOf()
            }
        } catch (e: Exception) {
        }

        cakeList.map {
            with(it) {
                Cake(
                    id,
                    name,
                    calories?.toDouble(),
                    image,
                    price?.toDouble(),
                    weight?.toDouble()
                )
            }
        }
    }

    suspend fun getCakeInfo(id: Long): CakeFullInfo = withContext(defaultDispatcher) {
        var cakeInfo: GetCakeFullInfoResponse

        try {
            val response = requestManager.getCakeInfo(id)
            cakeInfo = if(response.isSuccessful){
                response.body() ?: GetCakeFullInfoResponse.emptyObject()
            } else GetCakeFullInfoResponse.emptyObject()
        } catch (e: Exception) {
            cakeInfo = GetCakeFullInfoResponse.emptyObject()
        }

        var cakeFullInfo: CakeFullInfo
        cakeInfo.apply {
            cakeFullInfo = CakeFullInfo(id, name, calories?.toDouble(), image, price?.toDouble(), weight?.toDouble(), manufacturerName, storageConditions)
        }

        cakeFullInfo
    }
}