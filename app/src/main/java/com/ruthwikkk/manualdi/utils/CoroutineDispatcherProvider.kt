package com.ruthwikkk.manualdi.utils

import kotlinx.coroutines.Dispatchers

class CoroutineDispatcherProvider: DispatcherProvider {
    override val default = Dispatchers.Default
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
}