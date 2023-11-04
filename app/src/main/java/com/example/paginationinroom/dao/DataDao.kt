package com.example.paginationinroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paginationinroom.model.DataModel

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveData(dataModel: DataModel)

    @Query("SELECT * FROM sampleData ORDER BY id DESC LIMIT :limit OFFSET :offset")
    suspend fun getData(limit: Int, offset: Int): List<DataModel>

}