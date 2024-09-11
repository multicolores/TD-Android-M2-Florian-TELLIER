package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.model.MusculationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MusculationDao {

    @Query("SELECT * FROM musculation_object_table ORDER BY exerciseName ASC")
    fun selectAll(): Flow<List<MusculationEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: MusculationEntity)


    @Query("DELETE FROM musculation_object_table")
    fun deleteAll()
}
