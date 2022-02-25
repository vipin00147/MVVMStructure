package com.example.mvvmstructure.viewModel

import android.content.Context
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmstructure.R
import com.example.mvvmstructure.ui.activity.MainActivity
import com.example.mvvmstructure.utils.ConnectivityReceiver
import com.google.gson.JsonElement
import com.netset.counterbook.network.responseAndErrorHandle.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppViewModel(val mainActivity: MainActivity) : ViewModel(), ApiResponse, Callback<JsonElement> {

    lateinit var apiResponse : ApiResponse
    val isProgressShowing : MutableLiveData<Boolean> = MutableLiveData()

    fun hitApi(call: Call<JsonElement>?, showProgress: Boolean, context: Context, listener: ApiResponse) {

        if (ConnectivityReceiver().isConnectedOrConnecting(context)) {
            isProgressShowing.value = showProgress
            call?.enqueue(this)
            apiResponse = listener
        } else {
            android.os.Handler(Looper.getMainLooper()).postDelayed(Runnable {
                mainActivity.ApiFailure(context.getString(R.string.no_internet_available))
            }, 200)
        }
    }

    override fun onSuccess(call: Call<JsonElement>, responseCode: Int, response: String) {
        isProgressShowing.value = false
    }

    override fun onError(call: Call<JsonElement>, errorCode: Int, errorMsg: String) {
        isProgressShowing.value = false
        mainActivity?.apiResponseErrorHandling(errorMsg,errorCode)
    }

    override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
        onSuccess(call, response.code(),response?.body().toString())
    }

    override fun onFailure(call: Call<JsonElement>, t: Throwable) {
        isProgressShowing.value = false
        mainActivity.ApiFailure(t.message.toString())
    }
}