package com.mine.openinapp_android.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mine.openinapp_android.R
import com.mine.openinapp_android.navigation.HomeDestination.title
import com.mine.openinapp_android.ui.theme.OpenInApp_AndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, modifier: Modifier = Modifier, onRefresh:()->Unit) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        },
        actions = {

            FilledTonalIconButton(
                onClick = onRefresh,
                colors = IconButtonDefaults.filledTonalIconButtonColors(
                    containerColor = Color.White.copy(alpha = 0.12f)
                ),
                shape = RoundedCornerShape(5.dp),
            ) {
                Icon(
                    imageVector = Icons.Outlined.Refresh,
                    tint = Color.White,
                    contentDescription = "Refresh Icon"
                )
            }

            FilledTonalIconButton(
                onClick = {},
                colors = IconButtonDefaults.filledTonalIconButtonColors(
                    containerColor = Color.White.copy(alpha = 0.12f)
                ),
                shape = RoundedCornerShape(5.dp),
            ) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    tint = Color.White,
                    contentDescription = stringResource(R.string.setting)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}


@Preview
@Composable
fun PreviewTopBar() {
    OpenInApp_AndroidTheme {
        TopBar(title = "DashBoard", onRefresh = {} )
    }
}