package com.ruthwikkk.manualdi.di

import androidx.lifecycle.ViewModelProvider
import com.ruthwikkk.manualdi.activities.MainActivity
import com.ruthwikkk.manualdi.activities.MooseApplication
import com.ruthwikkk.manualdi.adapters.RocketsAdapter
import com.ruthwikkk.manualdi.utils.ViewModelProviderFactory
import com.ruthwikkk.manualdi.viewmodels.MainViewModel

object ActivityComponent {

    fun inject(activity: MainActivity){

        val appContainer = (activity.application as MooseApplication).appContainer

        activity.viewModel = ViewModelProvider(activity, ViewModelProviderFactory(MainViewModel::class) { MainViewModel(activity.application, appContainer.appRepository) }).get(MainViewModel::class.java)
        activity.adapter = RocketsAdapter()
    }
}