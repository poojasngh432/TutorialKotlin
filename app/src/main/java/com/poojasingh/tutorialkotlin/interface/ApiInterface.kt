package com.poojasingh.tutorialkotlin.`interface`

import com.poojasingh.tutorialkotlin.data.model.Repo
import com.poojasingh.tutorialkotlin.data.model.WeatherModel
import com.poojasingh.tutorialkotlin.data.remote.response.GitResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    companion object{
        const val BASE_URL = "https://trendings.herokuapp.com/"
    }

    @GET("api/weather/v2")
    fun getWeatherData(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?
    ): Call<WeatherModel>

    @GET("repo")
    fun getTrendingRepos(@Query("lang") lang: String,
                         @Query("since") since: String
    ): Single<Repo>

    @GET("search/repositories")
    fun getRepo(@Query("q") search: String = "trending",
                @Query("sort") sort: String = "stars"
    ): Call<GitResponse>

}