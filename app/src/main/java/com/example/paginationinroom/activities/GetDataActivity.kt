package com.example.paginationinroom.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.paginationinroom.adapter.DataPagingAdapter
import com.example.paginationinroom.databinding.ActivityGetDataBinding
import com.example.paginationinroom.viewModel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetDataBinding
    private val dataVM: DataViewModel by viewModels()
    lateinit var adapter: DataPagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        setAdapter()
    }

    private fun setAdapter() {
        adapter = DataPagingAdapter()
        binding.rvData.setHasFixedSize(true)
        binding.rvData.adapter = adapter

        dataVM.getDataList.observe(this) { dataList ->
            adapter.submitData(lifecycle, dataList)
        }
    }
}