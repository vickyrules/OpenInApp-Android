package com.mine.openinapp_android.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class ApiResponse(
    val status: Boolean,
    val statusCode: Int,
    val message: String,
    val support_whatsapp_number: String,
    val extra_income: Double,
    val total_links: Int,
    val total_clicks: Int,
    val today_clicks: Int,
    val top_source: String,
    val top_location: String,
    val startTime: String,
    val links_created_today: Int,
    val applied_campaign: Int,
    val data: Data

)