package com.samples.enparadigmtask.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by ak93.droid@gmail.com on 23,August,2020
 */
@Dao
interface WeatherDao {

    @Query("select * from weather_table")
    fun getWeather():LiveData<DatabaseWeather>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weather: DatabaseWeather)
}