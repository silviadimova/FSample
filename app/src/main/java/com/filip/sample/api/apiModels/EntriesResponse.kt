package com.filip.sample.api.apiModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class EntriesResponse(
    @SerializedName("count")
    val count :Int,
    @SerializedName("entries")
    val entries: List<Entry>
)

@Parcelize
data class Entry(
    @SerializedName("API")
    val api :String,
    @SerializedName("Description")
    val description :String,
    @SerializedName("Auth")
    val auth :String,
    @SerializedName("HTTPS")
    val https :Boolean,
    @SerializedName("Cors")
    val cors :String,
    @SerializedName("Link")
    val link :String,
    @SerializedName("Category")
    val category :String

) : Parcelable
