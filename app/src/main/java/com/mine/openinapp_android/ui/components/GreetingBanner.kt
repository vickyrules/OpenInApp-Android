package com.mine.openinapp_android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mine.openinapp_android.R
import com.mine.openinapp_android.ui.theme.OpenInApp_AndroidTheme
import com.mine.openinapp_android.ui.utils.GreetingString

@Composable
fun GreetingBanner() {
    Column() {
        Text(text = GreetingString(), style = MaterialTheme.typography.labelLarge)
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Ajay Manva", style = MaterialTheme.typography.titleLarge)
            Image(
                painter = painterResource(R.drawable.hand),
                modifier = Modifier.size(28.dp),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun PreviewGreetingBanner() {
    OpenInApp_AndroidTheme {
        GreetingBanner()
    }
}