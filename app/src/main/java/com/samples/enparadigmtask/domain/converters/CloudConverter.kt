package com.samples.enparadigmtask.domain.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.samples.enparadigmtask.domain.Clouds
import com.samples.enparadigmtask.domain.Wind

/**
 * Created by ak93.droid@gmail.com on 13,September,2020
 */
class CloudConverter {

    @TypeConverter
    fun convertCloudToString(cloud: Clouds): String{
        return Gson().toJson(cloud)
    }

    @TypeConverter
    fun convertStringToCloud(main:String): Clouds {
        val cloudType = object : TypeToken<Clouds>() {}.type
        return Gson().fromJson<Clouds>(main, cloudType)
    }
}