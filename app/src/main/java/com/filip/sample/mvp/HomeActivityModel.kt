package com.filip.sample.mvp

import android.content.SharedPreferences
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.filip.sample.api.MyPublicAPIService
import com.filip.sample.api.apiModels.EntriesResponse
import com.filip.sample.network.NetworkManager.retrofit
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val VALID_FIRST_NAME = "Silvia"
const val VALID_EMAIL = "silvia@email.bg"
const val VALID_PASSWORD = "mani4e"
class HomeActivityModel(private val preference: SharedPreferences) {

    val service: MyPublicAPIService = retrofit.create(MyPublicAPIService::class.java)

    val savedName = preference.getString("key", "")!!
    val savedEmail = preference.getString("key2", "")!!
    val savedPassword = preference.getString("key3", "")!!

     fun saveInput(name: String, email: String, password: String){
         val preferenceEditor = preference.edit()
         val preferenceEditor2 = preference.edit()
         val preferenceEditor3 = preference.edit()
         preferenceEditor.putString("key", name)
         preferenceEditor2.putString("key2", email)
         preferenceEditor3.putString("key3", password)
         preferenceEditor.apply()
         preferenceEditor2.apply()
         preferenceEditor3.apply()
    }

    fun getAllEntries(callback: Callback<EntriesResponse>) {
        service.getEntries(10).enqueue(callback)
    }

}
