package com.ruthwikkk.manualdi.activities

import android.app.Application
import com.ruthwikkk.manualdi.di.AppContainer

class MooseApplication: Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer()
    }
}