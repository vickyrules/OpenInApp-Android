package com.mine.openinapp_android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter.State.Empty.painter

@Composable
fun OutLineBtn(label:String, color: Color, iconBtn:Int) {
    OutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.Black
        ),
        contentPadding = PaddingValues(horizontal = 5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Image(
            modifier = Modifier.size(20.dp).padding(end = 5.dp),
            painter = painterResource(iconBtn),
            contentDescription = null,
        )
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium
        )
    }
}