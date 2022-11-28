package com.example.onlygains.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "email")
    val email: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "is_active")
    val isActive: Boolean,
    @Json(name = "posts")
    val posts: List<Post>,
    @Json(name = "username")
    val username: String,
    @Json(name = "workouts")
    val workouts: List<Workout>
)