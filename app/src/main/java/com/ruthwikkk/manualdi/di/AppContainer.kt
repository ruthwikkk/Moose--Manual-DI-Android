package com.ruthwikkk.manualdi.di

import com.ruthwikkk.manualdi.api.ApiClient
import com.ruthwikkk.manualdi.api.AppRepository

class AppContainer {
    private val apiService = ApiClient.create()
    val appRepository = AppRepository(apiService)
}