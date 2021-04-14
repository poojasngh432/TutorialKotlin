package com.poojasingh.tutorialkotlin.data.model

import com.google.gson.annotations.SerializedName
import com.poojasingh.tutorialkotlin.data.model.Items

data class Repo(
    @field:SerializedName("count")
    val count: Int? = null,
    @field:SerializedName("msg")
    val msg: String? = null,
    @field:SerializedName("items")
    val items: List<Items>? = null
)
