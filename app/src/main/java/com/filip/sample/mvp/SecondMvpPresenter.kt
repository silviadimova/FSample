package com.filip.sample.mvp


import com.filip.sample.api.apiModels.Entry

class SecondMvpPresenter (private val view: View, private val model: SecondMvpActivityModel){

    fun transferEntry(transferredEntry: Entry?){
        view.displaySelectedEntry(transferredEntry)
    }

    fun onClickApi(api: String?) {
        view.displayApiDialog(api)
    }

    fun onClickDescription(description: String?) {
        view.displayDescriptionDialog(description)
    }

    interface View{
        fun displaySelectedEntry(transferredEntry: Entry?)
        fun displayApiDialog(api: String?)
        fun displayDescriptionDialog(description: String?)

    }
}
