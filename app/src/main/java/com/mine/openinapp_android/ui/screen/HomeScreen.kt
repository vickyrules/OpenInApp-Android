package com.mine.openinapp_android.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.mine.openinapp_android.network.model.ApiResponse

@Composable
fun HomeScreen(viewModel: HomeViewModel,onClick: () -> Unit) {
    val homeUiState = viewModel.homeUiState

    when (homeUiState) {
        is HomeUiState.Loading -> LoadingScreen()
        is HomeUiState.Success -> Results(homeUiState.data, onClick = onClick)
        is HomeUiState.Error -> ErrorScreen()
    }
}


@Composable
fun Results(data: ApiResponse, onClick: () -> Unit) {
    Column {
        Text(text = data.message ?: "Not Found")
        Text(text = data.status.toString() ?: "fail")
        Text(text = data.statusCode.toString() ?: "408")
        Button(onClick = onClick) {
            Text(text = "Cal")
        }
    }
}


@Composable
fun LoadingScreen() {
    Text(text = "Loading")

}


@Composable
fun ErrorScreen() {
    Text(text = "Loading")
}
