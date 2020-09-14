package com.samples.enparadigmtask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.samples.enparadigmtask.domain.Main
import com.samples.enparadigmtask.domain.converters.CloudConverter
import com.samples.enparadigmtask.domain.converters.MainConverter
import com.samples.enparadigmtask.domain.converters.WeatherConverter
import com.samples.enparadigmtask.domain.converters.WindConverter

/**
 * Created by ak93.droid@gmail.com on 23,August,2020
 */

@Database(entities = [DatabaseWeather::class], version = 1, exportSchema = false)
@TypeConverters(MainConverter::class, WindConverter::class, CloudConverter::class, WeatherConverter::class)
abstract class WeatherDatabase: RoomDatabase(){
    abstract fun weatherDao(): WeatherDao

    companion object{

        @Volatile
        private var INSTANCE : WeatherDatabase? = null

        fun getDatabase(context: Context):WeatherDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    "weather_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}