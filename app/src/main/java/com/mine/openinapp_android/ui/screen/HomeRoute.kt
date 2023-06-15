package com.mine.openinapp_android.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeRoute(viewModel: HomeViewModel){
    HomeScreen(  viewModel = viewModel,viewModel::getData)
}