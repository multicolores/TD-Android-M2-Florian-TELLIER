package com.example.myapplication.ui.model

import com.example.myapplication.data.model.MusculationEntity


sealed interface ItemUi {
    data class Item(
        val exerciseName: String,
        val recoveryTime: String,
        val totalNumberOfRepetation: Int,
    ) : ItemUi

    data class Header(
        val title: String,
    ) : ItemUi

    data class Footer(
        val numberOfSet: Int,
    ) : ItemUi
}

//fun List<MusculationEntity>.toUi(): List<ItemUi.Item> {
//    return map { currentMusculationObject ->
//        ItemUi.Item(
//            exerciseName = currentMusculationObject.exerciseName,
//            recoveryTime = currentMusculationObject.recoveryTime,
//            totalNumberOfRepetation = currentMusculationObject.totalNumberOfRepetation
//        )
//    }
//}