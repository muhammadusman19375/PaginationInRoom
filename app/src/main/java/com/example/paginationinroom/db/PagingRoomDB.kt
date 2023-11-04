package com.example.paginationinroom.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paginationinroom.dao.DataDao
import com.example.paginationinroom.model.DataModel


@Database(entities = [DataModel::class], version = 1, exportSchema = false)
abstract class PagingRoomDB: RoomDatabase() {

    abstract fun getDataDao() : DataDao

}