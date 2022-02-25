package com.example.mvvmstructure.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmstructure.ui.activity.MainActivity
import com.example.mvvmstructure.viewModel.AppViewModel

class ViewModelFactory(val mainActivity: MainActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            return AppViewModel(mainActivity) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}