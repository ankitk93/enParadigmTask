package com.samples.enparadigmtask.network

import com.samples.enparadigmtask.database.DatabaseWeather
import kotlinx.coroutines.Deferred
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by ak93.droid@gmail.com on 23,August,2020
 */

interface ApiService{

    @POST("data/2.5/weather")
    fun getTodayWeather(@Query("q") cityName : String,
                        @Query("appid") appId: String) : Deferred<DatabaseWeather>
}