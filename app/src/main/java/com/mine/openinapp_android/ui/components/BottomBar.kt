package com.mine.openinapp_android.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mine.openinapp_android.R
import com.mine.openinapp_android.ui.theme.OpenInApp_AndroidTheme
import com.mine.openinapp_android.ui.utils.BottomBarContent


@Composable
fun BottomBar() {
    var selectedItem by remember { mutableStateOf(0) }
    NavigationBar {
        BottomBarContent.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(19.dp),
                        painter = painterResource(item.second),
                        contentDescription = item.first + " icons"
                    )
                },
                label = { Text(text = item.first,) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }

}



@Preview
@Composable
fun PreviewBottomBar() {
    OpenInApp_AndroidTheme {
        BottomBar()
    }
}

