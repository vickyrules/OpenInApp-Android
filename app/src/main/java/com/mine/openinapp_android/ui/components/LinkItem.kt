package com.mine.openinapp_android.ui.components

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mine.openinapp_android.R
import com.mine.openinapp_android.network.model.RecentLink
import com.mine.openinapp_android.network.model.TopLink
import com.mine.openinapp_android.ui.screen.scope
import com.mine.openinapp_android.ui.screen.snackbarHostState
import com.mine.openinapp_android.ui.utils.formatDateFromString
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LinkItem(item: RecentLink) {
    ElevatedCard(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppLogoImg(img_src = item.original_image, modifier = Modifier.weight(0.2f))
                Column(modifier = Modifier.weight(0.6f)) {
                    Text(
                        text = item.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = formatDateFromString(inputDateTime = item.created_at),
                        color = Color.LightGray,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                Column(
                    modifier = Modifier.weight(0.2f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = item.total_clicks.toString(),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "clicks",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.labelMedium
                    )
                }

            }
            Spacer(modifier = Modifier.height(3.dp))
            Divider(thickness = Dp.Hairline)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val clipboardManager = LocalClipboardManager.current
                val annotatedString = buildAnnotatedString {
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                        append(item.web_link)
                    }
                }

                LinkText(item.web_link, {}, modifier = Modifier.weight(0.8f))
                IconButton(onClick = {
                    clipboardManager.setText(annotatedString)
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Copied"
                        )
                    }

                }, modifier = Modifier.weight(0.2f)) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_content_copy_24),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )

                }
            }

        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LinkItem(item: TopLink) {
    ElevatedCard(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppLogoImg(img_src = item.original_image, modifier = Modifier.weight(0.2f))
                Column(modifier = Modifier.weight(0.6f)) {
                    Text(
                        text = item.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = formatDateFromString(inputDateTime = item.created_at),
                        color = Color.LightGray,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                Column(
                    modifier = Modifier.height(70.dp)
                        .fillMaxWidth()
                        .weight(0.2f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier,
                        text = item.total_clicks.toString(),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "clicks",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.labelMedium
                    )
                }

            }
            Spacer(modifier = Modifier.height(3.dp))
            Divider(thickness = Dp.Hairline)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val clipboardManager = LocalClipboardManager.current
                val annotatedString = buildAnnotatedString {
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                        append(item.web_link)
                    }
                }

                LinkText(item.web_link, {}, modifier = Modifier.weight(0.8f))
                IconButton(onClick = {
                    clipboardManager.setText(annotatedString)
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Copied"
                        )
                    }
                }, modifier = Modifier.weight(0.2f)) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_content_copy_24),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

        }
    }
}

@Composable
fun AppLogoImg(modifier: Modifier = Modifier, img_src: String) {
    AsyncImage(
        modifier = modifier.size(60.dp),
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(data = img_src)
            .crossfade(true)
            .build(),
        error = painterResource(id = R.drawable.ic_broken_image),
        placeholder = painterResource(id = R.drawable.loading_img),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}


@Composable
fun LinkText(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val annotatedString = buildAnnotatedString {
        pushStringAnnotation(
            tag = "LINK",
            annotation = onClick.toString()
        )
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append(text)
        }
        pop()
    }

    ClickableText(
        text = annotatedString,
        modifier = modifier.padding(5.dp),
        overflow = TextOverflow.Visible,
        softWrap = true,
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                onClick.invoke()
            }
        }
    )
}
