package com.ruthwikkk.manualdi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.ruthwikkk.manualdi.R
import com.ruthwikkk.manualdi.adapters.RocketsAdapter
import com.ruthwikkk.manualdi.di.ActivityComponent
import com.ruthwikkk.manualdi.interfaces.RecyclerItemClickListener
import com.ruthwikkk.manualdi.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.*


class MainActivity : AppCompatActivity(), RecyclerItemClickListener {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: RocketsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityComponent.inject(this)

        rv_rockets_list.adapter = adapter

        adapter.listener = this

        viewModel.apply {
            getData()
            items.observe(this@MainActivity, Observer {
                adapter.setItems(it)
            })
        }
    }

    override fun onListItemClicked(item: Any) {
        Log.e("Flow", "onListItemClicked()")
    }
}