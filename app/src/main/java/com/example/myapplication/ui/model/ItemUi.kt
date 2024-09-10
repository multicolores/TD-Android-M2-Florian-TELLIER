package com.example.myapplication.ui.model


sealed interface ItemUi {
    data class MusculationObject(
        val exerciseName: String,
        val recoveryTime: String,
        val totalNumberOfRepetation: Int,
    ): ItemUi

    data class Header(
        val title: String,
    ): ItemUi

    data class Footer(
        val numberOfSet: Int,
    ): ItemUi
}
