package com.netset.counterbook.network.responseAndErrorHandle

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ErrorMessage : Serializable {
    @SerializedName("message")
    @Expose
    var message: String? = null
}