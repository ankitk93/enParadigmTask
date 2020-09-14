package com.samples.enparadigmtask.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.samples.enparadigmtask.domain.Clouds
import com.samples.enparadigmtask.domain.Main
import com.samples.enparadigmtask.domain.Weather
import com.samples.enparadigmtask.domain.Wind

/**
 * Created by ak93.droid@gmail.com on 23,August,2020
 */

@Entity(tableName = "weather_table")
data class DatabaseWeather(@PrimaryKey @ColumnInfo(name = "id") val id: Int,
                           @ColumnInfo(name = "name")val name: String,
                           @ColumnInfo(name = "main")val main: Main,
                           @ColumnInfo(name = "wind")val wind: Wind,
                           @ColumnInfo(name = "clouds")val clouds: Clouds,
                           @ColumnInfo(name = "dt")val date: Long,
                           @ColumnInfo(name = "weather") val weather: List<Weather>)
