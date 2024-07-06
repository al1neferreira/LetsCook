package com.example.letscook.data.remote

import com.example.letscook.util.Constants
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private val httpClient: OkHttpClient
        get() {
            val clientBuilder = OkHttpClient.Builder()

            clientBuilder.addInterceptor { chain ->
                val original: Request = chain.request()
                val request = original.newBuilder()
                val originalHttpUrl = chain.request().url
                val newUrl = originalHttpUrl.newBuilder()
                    .addQueryParameter("apiKey", Constants.API_KEY).build()
                chain.proceed( request.url(newUrl).build())
            }

            return clientBuilder.build()
        }

    val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
