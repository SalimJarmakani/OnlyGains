package com.example.onlygains.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.onlygains.WorkoutViewModel
import com.example.onlygains.data.api.WorkoutRepo
import com.example.onlygains.data.models.Excercise
import com.example.onlygains.data.models.Workout
import kotlinx.coroutines.delay

@Composable
fun workoutList(workoutViewModel: WorkoutViewModel,navController: NavController){


    val state by workoutViewModel.state.collectAsState()

    Column() {





        LazyColumn {

            if (state.isEmpty()) {

                item {
                    CircularProgressIndicator(

                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }
            }

            items(state) { workout: Workout ->
                Spacer(modifier = Modifier.padding(10.dp))
                workoutCard(
                    workoutViewModel = workoutViewModel,
                    workout = workout,
                    navController = navController
                )

            }


        }

    }
}

@Composable
fun workoutCard(workoutViewModel: WorkoutViewModel
                ,workout: Workout,navController: NavController){

    Card(
        modifier = Modifier
            .height(150.dp)
            .clickable {
                workoutViewModel.get_specific_workout(workout.id)

                navController.navigate("e")
            },
        shape = RoundedCornerShape(45.dp),
        backgroundColor = Color(0xFF3F3F3F),
        border = BorderStroke(2.dp,Color(0xFF0066EE))
    ){
        Column (
            modifier= Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = workout.title,color=Color.White,
                fontWeight = FontWeight.Bold, fontSize = 25.sp, modifier = Modifier.padding(5.dp))

            Text(text = workout.description,color=Color.White, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)


        }
}}

@Composable
fun excercises(workoutViewModel: WorkoutViewModel){

    Column() {
        val workout by workoutViewModel.sWorkout.collectAsState()

        LazyColumn {

            if (workout.id == 0) {
                item {
                    CircularProgressIndicator()
                }
            } else {


                items(workout.excercises) { excercise: Excercise ->
                    Spacer(modifier = Modifier.padding(10.dp))
                    excerciseCard(excercise = excercise)
                }

            }
        }
    }
}

@Composable
fun excerciseCard(excercise:Excercise){
    Column(modifier =Modifier.fillMaxWidth()
        ,horizontalAlignment = Alignment.CenterHorizontally) {


          Card(
              modifier = Modifier
                  .height(150.dp),
              shape = RoundedCornerShape(25.dp),
              backgroundColor = Color(0xFF3F3F3F),
              border = BorderStroke(2.dp, Color(0xFFAD9D09))
          ) {
              Column(
                  modifier = Modifier
                      .width(350.dp)
                      .padding(5.dp)
              ) {
                  Spacer(modifier = Modifier.padding(10.dp))

                  Box(
                      modifier =
                      Modifier.align(
                          alignment =
                          Alignment.CenterHorizontally
                      )
                  ) {
                      Text(
                          excercise.name,
                          fontWeight = FontWeight.Bold, fontSize = 25.sp
                      )
                  }

                  Spacer(modifier = Modifier.padding(10.dp))

                  Row() {
                      Spacer(modifier = Modifier.padding(20.dp))
                      Text("Sets: ${excercise.sets}", fontSize = 17.sp)
                  }
                  Row() {
                      Spacer(modifier = Modifier.padding(20.dp))
                      Text("Description: ${excercise.description}",
                          fontSize = 17.sp)
                  }

              }
          } }

}

