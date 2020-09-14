package com.samples.enparadigmtask.domain.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.samples.enparadigmtask.domain.Main

/**
 * Created by ak93.droid@gmail.com on 13,September,2020
 */

class MainConverter{

    @TypeConverter
    fun convertMainToString(main: Main): String{
        return Gson().toJson(main)
    }

    @TypeConverter
    fun convertStringToMain(main:String): Main{
        val mainType = object : TypeToken<Main>() {}.type
        return Gson().fromJson<Main>(main, mainType)
    }
}