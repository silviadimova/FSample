package com.filip.sample.mvp

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.filip.sample.R
import com.filip.sample.api.apiModels.Entry

class SecondMvpActivity :AppCompatActivity(), SecondMvpPresenter.View {

    private val presenter: SecondMvpPresenter = SecondMvpPresenter(this, SecondMvpActivityModel())

    val entryApi: AppCompatTextView by lazy { findViewById(R.id.api) }
    val entryDescription: AppCompatTextView by lazy { findViewById(R.id.description) }
    val transferredEntry :Entry? by lazy { intent.extras?.getParcelable(ENTRY_KEY) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_mvp_activity_layout)
        val detailsButton = findViewById<AppCompatButton>(R.id.details)

        detailsButton.setOnClickListener {
            presenter.transferEntry(transferredEntry)
        }

        //entryApi.text = Repository.entry.api
        //entryDescription.text = Repository.entry.description
    }

    override fun displaySelectedEntry(transferredEntry: Entry?) {
        val transferredEntryView= View.inflate(this, R.layout.mvp_entry_item, null)
        val parentLayout = findViewById<LinearLayout>(R.id.second_activity_layout)
        parentLayout.addView(transferredEntryView)

        entryApi.text = transferredEntry?.api
        entryDescription.text = transferredEntry?.description

        entryApi.setOnClickListener {
            presenter.onClickApi(transferredEntry?.api)
        }

        entryDescription.setOnClickListener {
            presenter.onClickDescription(transferredEntry?.description)
        }

    }
    override fun displayApiDialog(api: String?) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage(transferredEntry?.api.toString()).setCancelable(false)
        alertDialog.setPositiveButton(getString(R.string.ok_button_text), object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog?.dismiss()
            }
        })
        alertDialog.show()
    }
    override fun displayDescriptionDialog(description: String?) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage(transferredEntry?.description.toString())
        alertDialog.show()

    }


}