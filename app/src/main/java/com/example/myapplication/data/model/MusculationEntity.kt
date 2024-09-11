package com.example.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.ui.model.ItemUi

@Entity(tableName = "musculation_object_table")
data class MusculationEntity(

    @ColumnInfo(name = "exerciseName")
    val exerciseName: String,

    @ColumnInfo(name = "recoveryTime")
    val recoveryTime: String,

    @ColumnInfo(name = "totalNumberOfRepetation")
    val totalNumberOfRepetation: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}


fun ItemUi.Item.toRoomObject(): MusculationEntity {
    return MusculationEntity(
        exerciseName = exerciseName,
        recoveryTime = recoveryTime,
        totalNumberOfRepetation = totalNumberOfRepetation
    )
}


fun List<MusculationEntity>.toUi(): List<ItemUi.Item> {
    return map { eachItem ->
        ItemUi.Item(
            exerciseName = eachItem.exerciseName,
            recoveryTime = eachItem.recoveryTime,
            totalNumberOfRepetation = eachItem.totalNumberOfRepetation
        )
    }
}
