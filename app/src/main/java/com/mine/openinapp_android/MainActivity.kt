package com.mine.openinapp_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.mine.openinapp_android.navigation.NavigationGraph
import com.mine.openinapp_android.ui.screen.HomeViewModel
import com.mine.openinapp_android.ui.theme.OpenInApp_AndroidTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            OpenInApp_AndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel:HomeViewModel  = hiltViewModel<HomeViewModel>()
                    OpenInApp(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}


@Composable
fun OpenInApp(viewModel: HomeViewModel){
    NavigationGraph(
        viewModel = viewModel
    )
}