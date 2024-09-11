package com.example.myapplication.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.dao.MusculationDao
import com.example.myapplication.data.model.MusculationEntity


@Database(
    entities = [
        MusculationEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun musculationDao(): MusculationDao
}
