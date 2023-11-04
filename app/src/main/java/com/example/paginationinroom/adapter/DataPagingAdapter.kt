package com.example.paginationinroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationinroom.databinding.ListItemDataBinding
import com.example.paginationinroom.model.DataModel

class DataPagingAdapter : PagingDataAdapter<DataModel, DataPagingAdapter.ViewHolder>(COMPARATOR) {
    inner class ViewHolder(val binding: ListItemDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            item?.let { dataItem ->
                tvId.text = dataItem.id.toString()
                tvName.text = dataItem.name
                tvAge.text = dataItem.age.toString()
            }
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<DataModel>() {
            override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                return oldItem == newItem
            }

        }
    }

}