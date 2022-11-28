package com.example.onlygains.data.api

import com.example.onlygains.data.models.Post
import com.example.onlygains.data.models.Workout
import javax.inject.Inject

class WorkoutRepo @Inject constructor(

    private val workoutApi : WorkoutApi
) {

    suspend fun getWorkouts(): List<Workout>{

        return workoutApi.getWorkout()
    }

    suspend fun getWorkout (w_id:Int): Workout{
        return workoutApi.getSpecificWorkout(w_id = w_id)
    }

    suspend fun getPosts ():List<Post>{

        return workoutApi.getPost()
    }


}