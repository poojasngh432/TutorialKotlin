package com.poojasingh.tutorialkotlin.data.repository

import com.poojasingh.tutorialkotlin.interfaces.ApiInterface
import com.poojasingh.tutorialkotlin.data.model.WeatherModel
import com.poojasingh.tutorialkotlin.data.remote.ApiClient
import com.poojasingh.tutorialkotlin.data.remote.response.GitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

    fun getWeatherData(mService: ApiInterface, lat: String, lon: String, onResult: (isSuccess: Boolean, response: WeatherModel?) -> Unit) {
        ApiClient.instance.getWeatherData(lat,lon)?.enqueue(object : Callback<WeatherModel> {
            override fun onResponse(call: Call<WeatherModel>?, response: Response<WeatherModel>) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<WeatherModel>?, t: Throwable?) {
                onResult(false, null)
            }

        })
//        mService
//            .getWeatherData(lat, lon)
//            .enqueue(object : Callback<WeatherModel>() {
//                override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
//                    super.onResponse(call, response)
//                    Log.d("WEATHERTEST", "inside onResponse() api call in WeatherRepository")
//                    Log.d("WEATHERTEST", "inside onResponse(): values for lat and lon - " + lat + " " + lon)
//                    if (response != null && response.isSuccessful)
//                        onResult(true, response.body()!!)
//                    else
//                        onResult(false, null)
//                }
//
//                override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
//                    super.onFailure(call, t)
//                    Log.d("WEATHERTEST", "inside onResponse() api call in WeatherRepository")
//                    onResult(false, null)
//                }
//            })
    }

    // GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: GitResponse?) -> Unit) {

        ApiClient.instance.getRepo().enqueue(object : Callback<GitResponse> {
            override fun onResponse(call: Call<GitResponse>?, response: Response<GitResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<GitResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: WeatherRepository? = null
        fun getInstance() = INSTANCE
            ?: WeatherRepository().also {
                INSTANCE = it
            }
    }
}