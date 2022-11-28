package com.example.onlygains

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onlygains.data.models.Excercise
import com.example.onlygains.data.models.Workout
import com.example.onlygains.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlyGainsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


val excercise1 = Excercise("Bench",1,"Bench",5,5,1)
val excercise2 = Excercise("Inclince dumbell",1,"Incline Dumbell",5,5,1)

val excercise_list :List<Excercise> = mutableListOf(excercise1, excercise2)
val workout = Workout("upper chest focused", excercise_list,1,1,
 "Chest workout","chest")

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnlyGainsTheme {
       excerciseCard(excercise1)
    }
}