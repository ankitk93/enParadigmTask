package com.samples.enparadigmtask.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.samples.enparadigmtask.database.WeatherDatabase.Companion.getDatabase
import com.samples.enparadigmtask.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * Created by ak93.droid@gmail.com on 13,September,2020
 */
class MainActivityViewModel(application: Application): AndroidViewModel(application){

    private val weatherRepository = WeatherRepository(getDatabase(application).weatherDao())

    val currentWeather = weatherRepository.currentWeather

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.IO)


    init {
        getDataFromRepo()
    }

    private fun getDataFromRepo(){
        viewModelScope.launch {
            try {
                weatherRepository.insertWeather()
            }catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}