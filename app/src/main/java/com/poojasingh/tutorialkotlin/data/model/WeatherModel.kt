package com.poojasingh.tutorialkotlin.data.model

import com.google.gson.annotations.SerializedName

data class WeatherModel(
        @field:SerializedName("code")
        val code: Int,
        @field:SerializedName("data")
        val data: Data,
        @field:SerializedName("status")
        val status: String
)

data class Data(
        @field:SerializedName("advisory")
        var advisory: CropAdvisory?,
        @field:SerializedName("daily")
        var daily: List<Daily>,
        @field:SerializedName("location")
        var location: String
)

data class CropAdvisory(
        @field:SerializedName("cards")
        val listOfCards: List<Cards>?,
        @field:SerializedName("title")
        var title: String
)

data class Cards(
        @field:SerializedName("crop_id")
        var cropId: String,
        @field:SerializedName("desc")
        var desc: String,
        @field:SerializedName("icon")
        var icon: String,
        @field:SerializedName("title")
        var title: String,
        @field:SerializedName("date")
        var date: String,
        @field:SerializedName("weekday")
        var weekday: String
)

data class Daily(
        @field:SerializedName("bg")
        var bg: String,

        @field:SerializedName("color")
        var color: String,

        @field:SerializedName("date")
        var date: String,

        @field:SerializedName("day")
        var day: Int,

        @field:SerializedName("desc")
        var desc: String,

        @field:SerializedName("epoch")
        var epoch: Long,

        @field:SerializedName("hrly")
        var hrly: List<Hrly>?,

        @field:SerializedName("hrly_str")
        var hrlyStr: String,

        @field:SerializedName("icon")
        var icon: String,

        @field:SerializedName("rain_prob")
        var rainProb: String,

        @field:SerializedName("rh_avg")
        var rhAvg: Int,

        @field:SerializedName("swipe")
        var swipe: Boolean,

        @field:SerializedName("temp_max")
        var tempMax: Int,

        @field:SerializedName("temp_min")
        var tempMin: Int,

        @field:SerializedName("weekday")
        var weekday: String
)

data class Hrly(
        @field:SerializedName("icon")
        var icon: String,

        @field:SerializedName("time")
        var time: String
)
