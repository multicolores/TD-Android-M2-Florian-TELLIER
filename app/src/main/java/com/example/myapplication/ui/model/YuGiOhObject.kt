package com.example.myapplication.ui.model

import com.example.myapplication.data.model.YuGiOhEntity

data class YuGiOhObject(
    val title: String,
    val type: String,
    val url: String?,
)

fun List<YuGiOhEntity>.toUi(): List<YuGiOhObject> {
    return map { eachEntity ->
        YuGiOhObject(
            title = eachEntity.name,
            type = eachEntity.type,
            url = eachEntity.cardImageUrl,
        )
    }
}
