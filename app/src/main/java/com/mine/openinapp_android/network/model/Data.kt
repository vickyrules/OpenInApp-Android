package com.mine.openinapp_android.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class Data(

    val recent_links: List<RecentLink>,
    val top_links: List<TopLink>,
    val overall_url_chart: Map<String,Int>
)