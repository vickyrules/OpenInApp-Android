package com.mine.openinapp_android.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopLink(
    @SerialName("app")
    val app: String, // youtube
    @SerialName("created_at")
    val createdAt: String, // 2022-01-12T13:57:49.000Z
    @SerialName("domain_id")
    val domainId: String, // inopenapp.com/
    @SerialName("original_image")
    val originalImage: String, // https://i.ytimg.com/vi/G0WTFfZqjz0/maxresdefault.jpg
    @SerialName("smart_link")
    val smartLink: String, // boyceavenue.inopenapp.com/boyce-avenue
    @SerialName("thumbnail")
    val thumbnail: Any?, // null
    @SerialName("times_ago")
    val timesAgo: String, // 1 yr ago
    @SerialName("title")
    val title: String, // Can't Help Falling In Love - Elvis Presley (Boyce Avenue acoustic cover) on Spotify & Apple
    @SerialName("total_clicks")
    val totalClicks: Int, // 213
    @SerialName("url_id")
    val urlId: Int, // 98953
    @SerialName("url_prefix")
    val urlPrefix: String?, // boyceavenue
    @SerialName("url_suffix")
    val urlSuffix: String, // boyce-avenue
    @SerialName("web_link")
    val webLink: String // https://boyceavenue.inopenapp.com/boyce-avenue
)