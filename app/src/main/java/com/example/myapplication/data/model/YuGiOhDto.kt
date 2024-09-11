package com.example.myapplication.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class YuGiOhDto (
    @Expose
    @SerializedName("data")
    val data: List<YuGiOhDtoChild>,
)

fun YuGiOhDto.toRoom(): YuGiOhEntity {
    return YuGiOhEntity(
        name = data.firstOrNull()?.name ?: "",
        type = data.firstOrNull()?.type ?: "",
        cardImageUrl = data.firstOrNull()?.card_images?.firstOrNull()?.imageUrl ?: "",
    )
}

data class YuGiOhDtoChild (
    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("type")
    val type: String,

    @Expose
    @SerializedName("card_images")
    val card_images: List<CardImage>
)

data class CardImage(
    @Expose
    @SerializedName("id")
    val id: Long,

    @Expose
    @SerializedName("image_url")
    val imageUrl: String,

    @Expose
    @SerializedName("image_url_small")
    val imageUrlSmall: String,

    @Expose
    @SerializedName("image_url_cropped")
    val imageUrlCropped: String
)


