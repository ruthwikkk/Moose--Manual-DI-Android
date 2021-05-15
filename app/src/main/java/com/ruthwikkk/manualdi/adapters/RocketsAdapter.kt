package com.ruthwikkk.manualdi.adapters

import android.content.DialogInterface
import android.view.View
import com.ruthwikkk.manualdi.R
import com.ruthwikkk.manualdi.databinding.ListCellRocketBinding
import com.ruthwikkk.manualdi.interfaces.RecyclerItemClickListener
import com.ruthwikkk.manualdi.models.Rocket
import com.ruthwikkk.manualdi.utils.bindings

class RocketsAdapter() : BaseAdapter() {

    var listener: RecyclerItemClickListener? = null

    override fun layout(type: String) = R.layout.list_cell_rocket

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        return RocketsViewHolder(view)
    }


    inner class RocketsViewHolder(view: View) : BaseViewHolder(view){

        private val binding: ListCellRocketBinding by bindings(view)

        override fun bindData(item: Any) {
            if(item is Rocket){

                binding.apply {
                    rocket = item
                }

                binding.root.setOnClickListener {
                    listener?.onListItemClicked(item)
                }
            }
        }
    }
}