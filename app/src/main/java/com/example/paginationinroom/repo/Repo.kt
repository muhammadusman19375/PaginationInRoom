package com.example.paginationinroom.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.paginationinroom.dao.DataDao
import com.example.paginationinroom.model.DataModel
import com.example.paginationinroom.pagingSource.DataPagingSource
import javax.inject.Inject

class Repo @Inject constructor(private val dao: DataDao) {

    suspend fun saveData(dataModel: DataModel) {
        dao.saveData(dataModel)
    }

    fun getData() = Pager(
        config = PagingConfig(pageSize = 20, enablePlaceholders = false, initialLoadSize = 10),
        pagingSourceFactory = { DataPagingSource(dao) }
    ).liveData

}