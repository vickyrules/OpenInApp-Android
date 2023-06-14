package com.mine.openinapp_android.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("overall_url_chart")
    val overallUrlChart: OverallUrlChart,
    @SerialName("recent_links")
    val recentLinks: List<RecentLink>,
    @SerialName("top_links")
    val topLinks: List<TopLink>
)