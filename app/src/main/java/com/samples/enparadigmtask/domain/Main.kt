package com.samples.enparadigmtask.domain

import com.google.gson.annotations.SerializedName

/**
 * Created by ak93.droid@gmail.com on 23,August,2020
 */

data class Main(@SerializedName("temp") val temp: Double,
                @SerializedName("humidity") val humidity: Int)