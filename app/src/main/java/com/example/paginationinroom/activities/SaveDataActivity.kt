package com.example.paginationinroom.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.paginationinroom.databinding.ActivityMainBinding
import com.example.paginationinroom.model.DataModel
import com.example.paginationinroom.viewModel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SaveDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataVM: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        setListener()
    }

    private fun setListener() {
        binding.btnSaveData.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val age = (0..2000).random()
                val dataModel = DataModel(null, "Usman", age)
                dataVM.saveData(dataModel)
            }
        }

        binding.btnGetData.setOnClickListener {
            startActivity(Intent(this@SaveDataActivity, GetDataActivity::class.java))
        }
    }

}