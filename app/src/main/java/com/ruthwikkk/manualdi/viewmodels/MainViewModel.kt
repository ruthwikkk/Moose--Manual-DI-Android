package com.ruthwikkk.manualdi.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ruthwikkk.manualdi.api.AppRepository
import com.ruthwikkk.manualdi.models.Rocket
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.*


class MainViewModel(application: Application, private val repository: AppRepository): AndroidViewModel(application) {

    //fun getData() = repository.getRocketsData()

    private val _items = MutableLiveData<List<Rocket>>()
    val items: LiveData<List<Rocket>> = _items

    fun getData() = viewModelScope.launch {
        repository.getRocketsData()
            .onStart {
                Log.e("Flow", "onStart()")
            }
            .catch {
                Log.e("Flow", "catch()")
            }
            .onCompletion {
                Log.e("Flow", "onCompletion()")
            }
            .onEmpty {
                Log.e("Flow", "onEmpty()")
            }
            .collect {
                Log.e("Flow", "collect()")
                Log.e("Flow", "${System.currentTimeMillis()}")
                _items.value = it
            }
    }
}