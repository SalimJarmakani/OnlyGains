package com.example.onlygains
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onlygains.BottomAppBar.BottomBarScreen
import com.example.onlygains.ui.theme.excercises
import com.example.onlygains.ui.theme.workoutList
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun Navigation(navController:NavHostController){
    val workoutViewModel= viewModel(modelClass = WorkoutViewModel::class.java)


    NavHost(navController = navController,
        startDestination = "Login" ){
        composable(route = "Login"){
            LoginPage(navController = navController)
        }

        composable(route=BottomBarScreen.Workouts.route){
            workoutList(workoutViewModel=workoutViewModel,navController=navController)
        }
        composable(route="e"){
            excercises(workoutViewModel = workoutViewModel)
        }
        
        composable(route = BottomBarScreen.Home.route){
            FeedScreen(workoutViewModel = workoutViewModel,navController=navController)
        }
    }

}


@Composable
fun G(name: String) {
    Text(text = "Hello $name!")
}