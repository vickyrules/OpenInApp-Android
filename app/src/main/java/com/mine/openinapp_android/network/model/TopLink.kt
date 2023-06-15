package com.mine.openinapp_android.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class TopLink(
    val url_id: Int,
    val web_link: String,
    val smart_link: String,
    val title: String,
    val total_clicks: Int,
    val original_image: String,
    val thumbnail: String?,
    val times_ago: String,
    val created_at: String,
    val domain_id: String,
    val url_prefix: String,
    val url_suffix: String,
    val app: String
)