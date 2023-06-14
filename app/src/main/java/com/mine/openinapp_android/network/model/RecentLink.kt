package com.mine.openinapp_android.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecentLink(
    @SerialName("app")
    val app: String, // nobroker
    @SerialName("created_at")
    val createdAt: String, // 2023-03-15T07:33:50.000Z
    @SerialName("domain_id")
    val domainId: String, // inopenapp.com/
    @SerialName("original_image")
    val originalImage: String, // https://assets.nobroker.in/nb-new/public/List-Page/ogImage.png
    @SerialName("smart_link")
    val smartLink: String, // inopenapp.com/4o5qk
    @SerialName("thumbnail")
    val thumbnail: Any?, // null
    @SerialName("times_ago")
    val timesAgo: String, // 3 month ago
    @SerialName("title")
    val title: String, // 651   Flats for Rent in Kormangla Bangalore, Bangalore Karnataka Without Brokerage - NoBroker Rental Properties in Kormangla Bangalore Karnataka Without Brokerage
    @SerialName("total_clicks")
    val totalClicks: Int, // 51
    @SerialName("url_id")
    val urlId: Int, // 146150
    @SerialName("url_prefix")
    val urlPrefix: Any?, // null
    @SerialName("url_suffix")
    val urlSuffix: String, // 4o5qk
    @SerialName("web_link")
    val webLink: String // https://inopenapp.com/4o5qk
)