package com.example.myapplication.network.responses.cakes.getCakeInfo

import com.example.myapplication.model.CakeFullInfo
import java.math.BigDecimal

data class GetCakeFullInfoResponse(
    val id: Long?,
    val name: String,
    val calories: BigDecimal?,
    val image: String,
    val price: BigDecimal?,
    val weight: BigDecimal?,
    val manufacturerName: String,
    val storageConditions: String?
) {
    companion object {
        fun emptyObject() = GetCakeFullInfoResponse(
            null,
            "",
            null,
            "",
            null,
            null,
            "",
            ""
        )
    }
}
