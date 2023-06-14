package com.mine.openinapp_android.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("applied_campaign")
    val appliedCampaign: Int, // 0
    @SerialName("data")
    val `data`: Data,
    @SerialName("extra_income")
    val extraIncome: Double, // 47.25
    @SerialName("links_created_today")
    val linksCreatedToday: Int, // 0
    @SerialName("message")
    val message: String, // success
    @SerialName("startTime")
    val startTime: String, // 19:00
    @SerialName("status")
    val status: Boolean, // true
    @SerialName("statusCode")
    val statusCode: Int, // 200
    @SerialName("support_whatsapp_number")
    val supportWhatsappNumber: String, // 8297368106
    @SerialName("today_clicks")
    val todayClicks: Int, // 20
    @SerialName("top_location")
    val topLocation: String, // Mountain View
    @SerialName("top_source")
    val topSource: String, // Direct
    @SerialName("total_clicks")
    val totalClicks: Int, // 900
    @SerialName("total_links")
    val totalLinks: Int // 178
)