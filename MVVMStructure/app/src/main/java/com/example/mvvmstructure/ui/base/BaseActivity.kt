package com.example.mvvmstructure.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mvvmstructure.R

abstract class BaseActivity  : AppCompatActivity() {

    fun changeFragment(fragment: Fragment, addToBackStack: Boolean) {

        val transition = supportFragmentManager.beginTransaction()
        transition.apply {
            replace(R.id.mainContainer, fragment)
            if(addToBackStack) {
                addToBackStack(null)
            }
            commit()
        }
    }

    fun apiResponseErrorHandling(errorMsg: String, errorCode: Int) {

    }

    fun ApiFailure(errorMsg: String) {

    }

}