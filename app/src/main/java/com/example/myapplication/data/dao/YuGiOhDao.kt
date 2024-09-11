package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.model.YuGiOhEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface YuGiOhDao {
    @Query("SELECT * FROM yu_gi_oh_table ORDER BY name ASC")
    fun selectAll(): Flow<List<YuGiOhEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chuckNorrisEntity: YuGiOhEntity)

    @Query("DELETE FROM yu_gi_oh_table")
    fun deleteAll()
}
