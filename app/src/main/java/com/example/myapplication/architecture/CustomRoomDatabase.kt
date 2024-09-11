package com.example.myapplication.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.dao.MusculationDao
import com.example.myapplication.data.dao.YuGiOhDao
import com.example.myapplication.data.model.MusculationEntity
import com.example.myapplication.data.model.YuGiOhEntity


@Database(
    entities = [
        MusculationEntity::class,
        YuGiOhEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun musculationDao(): MusculationDao
    abstract fun yuGiOhDao(): YuGiOhDao

}
