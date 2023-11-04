package com.example.paginationinroom.db

import android.content.Context
import androidx.room.Room
import com.example.paginationinroom.dao.DataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object dbModule {

    @Provides
    @Singleton
    fun providesPagingRoomDB(@ApplicationContext context: Context): PagingRoomDB {
        return Room.databaseBuilder(
            context,
            PagingRoomDB::class.java,
            "pagingRoomDB"
        ).build()
    }


    @Provides
    @Singleton
    fun providesSampleDataDao(db: PagingRoomDB): DataDao {
        return db.getDataDao()
    }

}