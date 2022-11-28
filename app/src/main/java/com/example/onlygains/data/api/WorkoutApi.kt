package com.example.onlygains.data.api

import com.example.onlygains.data.models.Post
import com.example.onlygains.data.models.Workout
import retrofit2.http.GET
import retrofit2.http.Path

interface WorkoutApi {


    @GET("/Workouts/")
    suspend fun getWorkout():List<Workout>

    @GET("/Workouts/{w_id}")
    suspend fun getSpecificWorkout(@Path("w_id") w_id:Int ):Workout


    @GET("/post/")
    suspend fun getPost():List<Post>

}