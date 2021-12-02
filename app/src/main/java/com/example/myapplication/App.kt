package com.example.myapplication

import android.app.Application

class App: Application() {
    lateinit var mainRouter: MainRouter
    override fun onCreate() {
        super.onCreate()
    }
}