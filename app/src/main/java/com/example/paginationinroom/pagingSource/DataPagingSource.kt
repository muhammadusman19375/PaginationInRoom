package com.example.paginationinroom.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationinroom.dao.DataDao
import com.example.paginationinroom.model.DataModel

class DataPagingSource(private val dao: DataDao) : PagingSource<Int, DataModel>() {
    override fun getRefreshKey(state: PagingState<Int, DataModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataModel> {
        return try {
            val position = params.key ?: 0
            val response = dao.getData(params.loadSize, position * params.loadSize)

            LoadResult.Page(
                data = response,
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}