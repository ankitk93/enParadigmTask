package com.samples.enparadigmtask.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


const val API_KEY = "023148822cc2ea34ef926103a9dede29"
const val BASE_URL = "https://api.openweathermap.org/"
const val ICON_URL = "https://openweathermap.org/img/w/"

@BindingAdapter("cel_tem")
fun getTempInCelsius(textView: TextView, temp: Double){
    val tempInCelsius = temp - 273.15f
    textView.text = tempInCelsius.roundToInt().toString()
}

@BindingAdapter("get_date_time")
fun setDateTime(textView: TextView, millis:Long){
    val dateTime = convertMillisToDateTime("HH:mm a - EEE, MMM dd")
    textView.text = dateTime
}

fun convertMillisToDateTime(dateFormat: String): String{
    // Create a DateFormatter object for displaying date in specified format.
    val formatter = SimpleDateFormat(dateFormat, Locale.ENGLISH)

    val calendar = Calendar.getInstance()
    return formatter.format(calendar.time)
}

@BindingAdapter("load_icon")
fun showWeatherIcon(imageView: ImageView, icon: String){
    val iconUrl = "$ICON_URL$icon.png"

    iconUrl.let {
        Glide.with(imageView.context)
            .load(iconUrl)
            .into(imageView)
    }
}