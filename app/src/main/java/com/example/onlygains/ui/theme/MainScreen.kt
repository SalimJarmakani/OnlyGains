package com.example.onlygains.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.onlygains.BottomAppBar.BottomBarScreen
import com.example.onlygains.Navigation

@Composable
fun MainScreen(){
    val navController = rememberNavController()


    Scaffold(
        bottomBar = {
            if (currentRoute(navController = navController)!="Login")
                BottomBar(navController = navController)},
        topBar = {        TopAppBar(title = { Text("OnlyGains", fontWeight = FontWeight.Bold
            , fontSize = 25.sp) })}
    ) { innerPadding ->
        Box(modifier=Modifier.padding(innerPadding)
        ) {
            Navigation(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screen = listOf(

        BottomBarScreen.Home,
        BottomBarScreen.Workouts

    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation{
        screen.forEach { screen->
            AddItem(screen = screen, currentDestination =currentDestination ,
                navController =navController )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen:BottomBarScreen
    ,currentDestination:NavDestination?,
    navController: NavHostController){

    BottomNavigationItem(
        label = {
            Text(text=screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation icon")
        },
        selected =currentDestination?.hierarchy?.any {
            it.route==screen.route
        }==true,

        onClick = {navController.navigate(screen.route)}
    ) 

}

@Composable
fun currentRoute(navController: NavHostController) : String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}