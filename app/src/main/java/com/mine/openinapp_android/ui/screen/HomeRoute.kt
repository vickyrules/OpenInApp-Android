package com.mine.openinapp_android.ui.screen

import androidx.compose.runtime.Composable

@Composable
fun HomeRoute(viewModel: HomeViewModel){
    HomeScreen(  viewModel = viewModel,viewModel::getData)
}