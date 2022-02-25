package com.netset.counterbook.network

import android.text.TextUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object ApiConstants {

    private var requestTimeout = 60
    var authToken = ""

    private var retrofit : Retrofit? = null
    private var okHttpClient: OkHttpClient? = null
    val BASE_URL: String
        get() = "http://157.245.218.104:9005"


    // Create Service
    val service = getClient()?.create(ApiServices::class.java)


    fun getApiServices(): ApiServices? {
        return service
    }

    // Create Retrofit Client
    fun getClient(): Retrofit {

        if (okHttpClient == null)
            initOkHttp()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient!!)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

        return retrofit!!
    }

    private fun initOkHttp() {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(requestTimeout.toLong(), TimeUnit.SECONDS)
            .readTimeout(requestTimeout.toLong(), TimeUnit.SECONDS)
            .writeTimeout(requestTimeout.toLong(), TimeUnit.SECONDS)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(interceptor)

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("timezone", TimeZone.getDefault().id)

            /*  .addHeader("deviceType", "Android")
              .addHeader("appVersion", BuildConfig.VERSION_NAME)

               Adding Authorization token (API Key)
               Requests will be denied without API key
          if (!TextUtils.isEmpty(PrefUtils().getAuthKey(context))) {
              requestBuilder.addHeader("Authorization","Bearer ${PrefUtils().getAuthKey(context)!!}")
          }*/
            if (!TextUtils.isEmpty(authToken)) {
                requestBuilder.addHeader("Authorization", "Token "+authToken)
            }

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        okHttpClient = httpClient.build()
    }
}