package com.filip.sample.api

import com.filip.sample.api.apiModels.EntriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface MyPublicAPIService {
    @GET("entries")
    fun getEntries(@Header("my_hour") hour: Int): Call<EntriesResponse>
}
