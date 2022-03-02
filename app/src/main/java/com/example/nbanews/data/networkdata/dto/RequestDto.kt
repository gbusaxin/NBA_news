package com.example.nbanews.data.networkdata.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
class RequestDto(
    @SerializedName("locale")
    @Expose
    var request: String
)