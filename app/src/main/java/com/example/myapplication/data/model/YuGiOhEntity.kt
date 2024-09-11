package com.example.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "yu_gi_oh_table")
data class YuGiOhEntity(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "cardImageUrl")
    val cardImageUrl: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
