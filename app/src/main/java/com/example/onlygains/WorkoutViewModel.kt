package com.example.onlygains

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlygains.data.api.WorkoutRepo
import com.example.onlygains.data.models.Excercise
import com.example.onlygains.data.models.Post
import com.example.onlygains.data.models.Workout
import com.example.onlygains.ui.theme.workoutCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(

    private val workoutRepo : WorkoutRepo

) : ViewModel() {

   private val _state = MutableStateFlow(emptyList<Workout>())


    private val _sWorkout = MutableStateFlow(Workout("", emptyList<Excercise>(),0,0,"",""))

    private val _posts  = MutableStateFlow(emptyList<Post>())



    val state: StateFlow<List<Workout>>

    get() = _state

    val sWorkout:StateFlow<Workout>

    get() = _sWorkout

    val posts:StateFlow<List<Post>>
    get() = _posts
    init {

        viewModelScope.launch {

            val workouts = workoutRepo.getWorkouts()
            _state.value = workouts

            val posts= workoutRepo.getPosts()
            _posts.value=posts


        }
    }

    fun get_specific_workout(id:Int){


        viewModelScope.launch {
            _sWorkout.value = workoutRepo.getWorkout(w_id = id)

        }
    }

}