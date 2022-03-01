package com.example.mvvmstructure.ui.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mvvmstructure.R
import com.example.mvvmstructure.viewModel.AppViewModel

abstract class BaseActivity  : AppCompatActivity() {

    var appViewModel : AppViewModel ?= null

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
        Toast.makeText(this, "$errorCode $errorMsg", Toast.LENGTH_SHORT).show()
    }

    fun apiFailure(errorMsg: String) {
        Toast.makeText(this, "$errorMsg", Toast.LENGTH_SHORT).show()
    }

}