package com.poojasingh.tutorialkotlin.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by gauravgoyal on 15/12/17.
 */
class News {
    @SerializedName("status")
    @Expose
    val status: String? = null
    @SerializedName("totalResults")
    @Expose
    val totalResults: Int = 0
    @SerializedName("articles")
    @Expose
    val articles: List<Article>? = null

}
