package com.mine.openinapp_android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.PagingSource
import androidx.paging.compose.items
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.mine.openinapp_android.R

@Composable
fun More_Details(lstValues:List<String>){
    val listItem:List<Pair<String,Int>> = listOf(Pair("Today's clicks", R.drawable.ic_todays_click), Pair("Top location",R.drawable.ic_top_location), Pair("Top source",R.drawable.ic_top_source))

    LazyRow() {
       items(3){it ->
       DetailsItem(label = listItem[it].first, value = lstValues[it], listItem[it].second )
       }
    }
}

@Composable
private fun DetailsItem(label:String, value: String, itemIconId:Int){
    ElevatedCard(modifier = Modifier.size(140.dp).padding(horizontal = 5.dp)){
        Column(modifier = Modifier.fillMaxSize().padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly) {
            Image(painter = painterResource(itemIconId),contentDescription = null, modifier = Modifier.size(32.dp))
                Text(text = value, style = MaterialTheme.typography.titleMedium)
                Text(text = label, color = Color.LightGray)
        }
    }

}