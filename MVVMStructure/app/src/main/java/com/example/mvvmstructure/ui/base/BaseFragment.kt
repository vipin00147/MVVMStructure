package com.example.mvvmstructure.ui.base

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    var baseActivity : BaseActivity ?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = context as BaseActivity
    }

    @JvmName("getBaseActivity1")
    fun getBaseActivity(): BaseActivity {
        return baseActivity!!
    }
}