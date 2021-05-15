package com.ruthwikkk.manualdi.api

import com.ruthwikkk.manualdi.models.Rocket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AppRepository(val api: ApiService){

    fun getRocketsData(): Flow<List<Rocket>> {
        return flow {
            val response = api.getRockets()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}