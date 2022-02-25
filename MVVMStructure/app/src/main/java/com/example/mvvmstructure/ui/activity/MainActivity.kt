package com.example.mvvmstructure.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmstructure.R
import com.example.mvvmstructure.ui.base.BaseActivity
import com.example.mvvmstructure.ui.fragment.MainFragment
import com.example.mvvmstructure.utils.ViewModelFactory
import com.example.mvvmstructure.viewModel.AppViewModel

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initiateViewModel()
        changeFragment(MainFragment(), false)
    }

    private fun initiateViewModel() {
        appViewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(AppViewModel::class.java)
    }

}