package com.example.mvvmstructure.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmstructure.R
import com.example.mvvmstructure.databinding.FragmentMainBinding
import com.example.mvvmstructure.ui.base.BaseFragment
import com.example.mvvmstructure.utils.ViewModelFactory
import com.example.mvvmstructure.viewModel.AppViewModel

class MainFragment : BaseFragment() {

    private var rootView: View? = null
    private var binding : FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (rootView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
            rootView = binding?.root
        }
        return rootView
    }

}