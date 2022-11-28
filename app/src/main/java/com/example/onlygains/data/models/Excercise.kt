package com.example.onlygains.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Excercise(
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "reps")
    val reps: Int,
    @Json(name = "sets")
    val sets: Int,
    @Json(name = "workout_id")
    val workoutId: Int
)