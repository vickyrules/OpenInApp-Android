package com.mine.openinapp_android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mine.openinapp_android.ui.screen.HomeRoute
import com.mine.openinapp_android.ui.screen.HomeViewModel

@Composable
fun  NavigationGraph(
    viewModel: HomeViewModel,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = HomeDestination.route
    ){
        composable(
            route = HomeDestination.route
        ){
            HomeRoute(  viewModel = viewModel)
        }
    }

}