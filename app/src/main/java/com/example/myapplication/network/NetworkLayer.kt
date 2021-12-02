package com.example.myapplication.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.R
import android.provider.Settings.Global.getString
import com.example.myapplication.network.managers.CakeManagerApi
import com.example.myapplication.network.managers.CakeRequestManager

object NetworkLayer {
    private val gson = GsonBuilder().create()
    private val httpClient= OkHttpClient().newBuilder().build()
    private val baseurl = "http://192.168.1.37:8080"

    val cakeRequestManager by lazy {
        val apiManager =  retrofit.create(CakeManagerApi::class.java)
        CakeRequestManager(apiManager)
    }

    private val retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}