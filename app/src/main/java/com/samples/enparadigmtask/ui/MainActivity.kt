package com.samples.enparadigmtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.samples.enparadigmtask.R
import com.samples.enparadigmtask.databinding.MainActivityBinding
import com.samples.enparadigmtask.viewModel.MainActivityViewModel
import com.samples.enparadigmtask.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        val viewModelFactory = MainViewModelFactory(application)
        val viewModel: MainActivityViewModel by lazy {
            ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)
        }

        binding.viewModel = viewModel

        binding.lifecycleOwner = this
    }
}
