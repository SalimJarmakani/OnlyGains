package com.example.onlygains.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "likes")
    val likes: Int,
    @Json(name = "uid")
    val uid: Int,
    @Json(name = "wid")
    val wid: Int
)