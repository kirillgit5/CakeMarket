package com.example.myapplication.model

data class CakeFullInfo(
    val id: Long?,
    val name: String,
    val calories: Double?,
    val image: String,
    val price: Double?,
    val weight: Double?,
    val manufacturerName: String,
    val storageConditions: String?
) {
    companion object {
        fun emptyObject() = CakeFullInfo(
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
