package com.example.concurrent_sync_lab.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
     val retrofit = Retrofit.Builder()
        .baseUrl("https://hi-lingual-clone-default-rtdb.firebaseio.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
