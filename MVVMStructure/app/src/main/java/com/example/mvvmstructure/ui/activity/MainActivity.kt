package com.example.mvvmstructure.ui.activity

import android.os.Bundle
import com.example.mvvmstructure.R
import com.example.mvvmstructure.ui.base.BaseActivity
import com.example.mvvmstructure.ui.fragment.MainFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment(MainFragment(), false)
    }
}