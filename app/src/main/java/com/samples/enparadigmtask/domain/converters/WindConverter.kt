package com.samples.enparadigmtask.domain.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.samples.enparadigmtask.domain.Main
import com.samples.enparadigmtask.domain.Wind

/**
 * Created by ak93.droid@gmail.com on 13,September,2020
 */
class WindConverter {

    @TypeConverter
    fun convertWindToString(wind: Wind): String{
        return Gson().toJson(wind)
    }

    @TypeConverter
    fun convertStringToWind(main:String): Wind {
        val windType = object : TypeToken<Wind>() {}.type
        return Gson().fromJson<Wind>(main, windType)
    }
}