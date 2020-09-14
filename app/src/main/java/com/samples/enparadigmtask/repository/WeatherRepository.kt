package com.samples.enparadigmtask.repository


import androidx.lifecycle.LiveData
import com.samples.enparadigmtask.database.DatabaseWeather
import com.samples.enparadigmtask.database.WeatherDao
import com.samples.enparadigmtask.network.RetrofitClient
import com.samples.enparadigmtask.utils.API_KEY


class WeatherRepository(private val dao: WeatherDao) {

    suspend fun insertWeather(){
        val currentWeather = RetrofitClient.apiService.
        getTodayWeather("Bangalore", API_KEY).await()
        dao.insert(currentWeather)
    }

    val currentWeather: LiveData<DatabaseWeather> = dao.getWeather()
}