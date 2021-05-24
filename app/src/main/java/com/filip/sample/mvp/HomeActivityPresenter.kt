package com.filip.sample.mvp

import com.filip.sample.R
import com.filip.sample.api.apiModels.EntriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivityPresenter(private val view: View, private val model: HomeActivityModel) {

    fun onSubmit(text: String, email: String, password: String) {
        if (text.isEmpty()){
            view.showError(R.string.empty_name_error)}
        else if (email.isEmpty()){
            view.showError(R.string.empty_email_error)}
        else if (password.isEmpty()){
            view.showError(R.string.empty_password_error)
        }else {
            view.hideError()
            view.drawText(text, email, password)
        }
        model.saveInput(text,email,password)
    }

    fun readPreference() {
        if(model.savedName== VALID_FIRST_NAME && model.savedEmail== VALID_EMAIL && model.savedPassword== VALID_PASSWORD){
            view.navigateTo(SecondMvpActivity::class.java)
        }else {
            view.displayCache(model.savedName, model.savedEmail, model.savedPassword)
        }
        model.getAllEntries(object: Callback<EntriesResponse> {
            override fun onResponse(call: Call<EntriesResponse>, response: Response<EntriesResponse>) {
                view.displayEntries(response.body())
            }

            override fun onFailure(call: Call<EntriesResponse>, error: Throwable) {
                view.displayApiError(error.localizedMessage)
            }
        })
    }
    fun respondToCredentials(text: String,email: String,password: String){
        if (text== VALID_FIRST_NAME && email== VALID_EMAIL && password== VALID_PASSWORD ){
            view.navigateTo(SecondMvpActivity::class.java)
        }else{
            view.drawText(text,email,password)
        }
    }


    interface View{
        fun drawText(text: String, email: String, password: String)
        fun showError(message :Int)
        fun hideError()
        fun navigateTo(target :Class<*>)
        fun displayCache(cachedText: String, cachedEmail: String, cachedPassword: String)
        fun displayEntries(entriesData :EntriesResponse?)
        fun displayApiError(error :String)
    }
}