package com.ruthwikkk.manualdi.utils

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
}