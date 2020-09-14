package com.samples.enparadigmtask.domain.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.samples.enparadigmtask.domain.Weather

/**
 * Created by ak93.droid@gmail.com on 13,September,2020
 */
class WeatherConverter{
    @TypeConverter
    fun convertWeatherToString(weather: List<Weather>): String{
        return Gson().toJson(weather)
    }

    @TypeConverter
    fun convertStringToWeather(main:String): List<Weather> {
        val weatherType = object : TypeToken<List<Weather>>() {}.type
        return Gson().fromJson<List<Weather>>(main, weatherType)
    }
}