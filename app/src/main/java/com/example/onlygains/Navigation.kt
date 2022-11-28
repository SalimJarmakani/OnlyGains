package com.example.onlygains
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onlygains.ui.theme.excercises
import com.example.onlygains.ui.theme.workoutList
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun Navigation(){
    val workoutViewModel= viewModel(modelClass = WorkoutViewModel::class.java)

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "f" ){
        composable(route = "Login"){
            LoginPage(navController = navController)
        }

        composable(route="h"){
            workoutList(workoutViewModel=workoutViewModel,navController=navController)
        }
        composable(route="e"){
            excercises(workoutViewModel = workoutViewModel)
        }
        
        composable(route = "f"){
            FeedScreen(workoutViewModel = workoutViewModel,navController=navController)
        }
    }

}


@Composable
fun G(name: String) {
    Text(text = "Hello $name!")
}