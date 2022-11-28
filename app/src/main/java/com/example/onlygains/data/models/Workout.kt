package com.example.onlygains.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Workout(
    @Json(name = "description")
    val description: String,
    @Json(name = "excercises")
    val excercises: List<Excercise>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "owner_id")
    val ownerId: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "type")
    val type: String
)