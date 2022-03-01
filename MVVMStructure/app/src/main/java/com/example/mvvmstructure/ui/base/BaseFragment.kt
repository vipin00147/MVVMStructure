package com.example.mvvmstructure.ui.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.mvvmstructure.ui.activity.MainActivity

abstract class BaseFragment : Fragment() {

    var baseActivity : BaseActivity ?= null
    var mainActivity : MainActivity ?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = context as BaseActivity
        mainActivity = context as MainActivity
    }

    @JvmName("getBaseActivity1")
    fun getBaseActivity(): BaseActivity {
        return baseActivity!!

    }
}