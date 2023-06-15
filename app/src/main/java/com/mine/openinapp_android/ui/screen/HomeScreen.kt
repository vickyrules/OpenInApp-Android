package com.mine.openinapp_android.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mine.openinapp_android.R
import com.mine.openinapp_android.navigation.HomeDestination
import com.mine.openinapp_android.network.model.ApiResponse
import com.mine.openinapp_android.network.model.RecentLink
import com.mine.openinapp_android.network.model.TopLink
import com.mine.openinapp_android.ui.components.BottomBar
import com.mine.openinapp_android.ui.components.GreetingBanner
import com.mine.openinapp_android.ui.components.LinkItem
import com.mine.openinapp_android.ui.components.More_Details
import com.mine.openinapp_android.ui.components.OutLineBtn
import com.mine.openinapp_android.ui.components.OverViewChart
import com.mine.openinapp_android.ui.components.TopBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.json.JsonNull.content


lateinit  var snackbarHostState:SnackbarHostState
lateinit var scope:CoroutineScope


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(viewModel: HomeViewModel, onRefresh: () -> Unit) {
    val homeUiState = viewModel.homeUiState
    scope = rememberCoroutineScope()
    snackbarHostState = remember { SnackbarHostState() }
    snackbarHostState = remember { SnackbarHostState() }
    when (homeUiState) {
        is HomeUiState.Loading -> LoadingScreen()
        is HomeUiState.Success -> Results(viewModel, homeUiState.data, onRefresh = onRefresh)
        is HomeUiState.Error -> ErrorScreen(message = homeUiState.message, retryAction = onRefresh)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Results(viewModel: HomeViewModel, data: ApiResponse, onRefresh: () -> Unit) {

    Scaffold(
        topBar = { TopBar(title = HomeDestination.title, onRefresh = onRefresh) },
        bottomBar = { BottomBar() },
        snackbarHost = {
            SnackbarHost(snackbarHostState)},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Handle FAB click
                },
                modifier = Modifier.offset(y = 50.dp)
                    .clip(RoundedCornerShape(50.dp)),
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor =Color.White ,
                content = {
                    // Add FAB icon or content here
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "FAB"
                    )
                }
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = MaterialTheme.colorScheme.primary,
    )
    { innerPadding ->

        LazyColumn(
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .padding(innerPadding).clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                ).background(MaterialTheme.colorScheme.background)
        ) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    GreetingBanner()
                    OverViewChart(viewModel.customStepChartEntryModelProducer)
                    Spacer(modifier = Modifier.height(10.dp))
                    More_Details(
                        listOf(
                            data.today_clicks.toString(),
                            data.top_location,
                            data.top_source
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutLineBtn(
                        label = stringResource(R.string.view_analytics),
                        color = Color.Transparent,
                        iconBtn = R.drawable.ic_analytic
                    )

                    MiddleLazyLayout(data = data)
                    Spacer(modifier = Modifier.height(10.dp))
                    OutLineBtn(
                        label = stringResource(R.string.view_all_links),
                        color = Color.Transparent,
                        iconBtn = R.drawable.ic_links
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutLineBtn(
                        label = stringResource(R.string.talk_with_us),
                        color = Color.Green.copy(alpha = .12f),
                        iconBtn = R.drawable.ic_whatapp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutLineBtn(
                        label = stringResource(R.string.frequently_asked_question),
                        color = MaterialTheme.colorScheme.primary.copy(alpha = .12f),
                        iconBtn = R.drawable.ic_faq
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                }
            }

        }
    }


}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MiddleLazyLayout(data: ApiResponse) {
    Column(
        modifier = Modifier.height(500.dp)
    ) {
        var btnEnabled: Boolean by remember { mutableStateOf(true) }
        LinkeBtnGp(topLinkBtnEnable = btnEnabled) { enabled ->
            btnEnabled = enabled
        }
        if (btnEnabled) {
            LinksRecentList(linksList = data.data.recent_links)
        } else {
            LinksTopList(linksList = data.data.top_links)
        }

    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LinksRecentList(linksList: List<RecentLink>) {

    LazyColumn(modifier = Modifier) {
        items(linksList.sortedByDescending { it.created_at }) { item ->
            LinkItem(item = item)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LinksTopList(linksList: List<TopLink>) {
    LazyColumn() {
        items(linksList.sortedByDescending { it.total_clicks }) { item ->
            LinkItem(item = item)
        }
    }
}


@Composable
fun LinkeBtnGp(topLinkBtnEnable: Boolean, onClick: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        TextButton(
            modifier = Modifier,
            onClick = { onClick(true) }, colors = buttonColors(
                containerColor = if (topLinkBtnEnable) MaterialTheme.colorScheme.primary else Color.Transparent
            )
        ) {
            Text("Top Links", color = if(topLinkBtnEnable) Color.White else Color.LightGray)
        }
        Button(
            modifier = Modifier.offset(x = -20.dp),
            onClick = { onClick(false) }, colors = buttonColors(
                contentColor = Color.White,
                containerColor = if (!topLinkBtnEnable) MaterialTheme.colorScheme.primary else Color.Transparent
            )
        ) {
            Text("Recent Links",color = if(!topLinkBtnEnable) Color.White else Color.LightGray)
        }

        FilledTonalIconButton(
            modifier = Modifier,
            onClick = {},
            colors = IconButtonDefaults.filledTonalIconButtonColors(
                containerColor = Color.Gray.copy(alpha = 0.12f)
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                tint = Color.LightGray,
                contentDescription = stringResource(R.string.setting)
            )
        }
    }
}


@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = "laoding"
        )

    }
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(message: String, retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Failed")
        Button(onClick = retryAction) {
            Text("retry")
        }

        Snackbar {
            Text(text = message)
        }
    }
}