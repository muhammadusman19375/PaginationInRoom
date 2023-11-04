package com.example.paginationinroom.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.paginationinroom.model.DataModel
import com.example.paginationinroom.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val repo: Repo) : ViewModel() {

    suspend fun saveData(dataModel: DataModel) {
        repo.saveData(dataModel)
    }

    val getDataList = repo.getData().cachedIn(viewModelScope)

}