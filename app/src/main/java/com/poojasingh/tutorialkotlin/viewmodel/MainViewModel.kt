package com.poojasingh.tutorialkotlin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poojasingh.tutorialkotlin.interfaces.ApiInterface
import com.poojasingh.tutorialkotlin.data.model.WeatherModel
import com.poojasingh.tutorialkotlin.data.remote.ApiClient
import com.poojasingh.tutorialkotlin.data.remote.response.GitResponse
import com.poojasingh.tutorialkotlin.data.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val weatherDataLiveData = MutableLiveData<WeatherModel> ()
    val dataExists = MutableLiveData<Boolean>().apply { value = false }
    val responseStatus = MutableLiveData<String>().apply { value = "noloading" }

    fun fetchWeatherDataList(mService: ApiInterface, lat: String, lon: String) {
        dataExists.value = false
        responseStatus.value = "loading"
        Log.d("WEATHERTEST", "inside fetchWeatherDataList() in WeatherViewModel")
        WeatherRepository.getInstance().getWeatherData(mService, lat, lon, { isSuccess, response -> Unit
            Log.d("WEATHERTEST", "inside getWeatherData() api call in WeatherViewModel")
            if (isSuccess) {
                if (response != null && response.code == 400) {
                    dataExists.value = false
                    responseStatus.value = "error"
                } else if(response?.data != null){
                    dataExists.value = true
                    responseStatus.value = "success"
                }
                weatherDataLiveData.value = response
            } else {
                dataExists.value = false
                responseStatus.value = "error"
            }
        })
    }

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

}