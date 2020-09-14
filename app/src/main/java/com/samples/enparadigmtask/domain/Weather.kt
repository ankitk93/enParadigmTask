package com.samples.enparadigmtask.domain

import com.google.gson.annotations.SerializedName

/**
 * Created by ak93.droid@gmail.com on 13,September,2020
 */
data class Weather(@SerializedName("main") val title: String,
                   @SerializedName("description")val desc: String,
                   @SerializedName("icon") val icon:String) {
}