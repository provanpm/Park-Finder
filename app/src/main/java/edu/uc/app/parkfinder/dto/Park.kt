package edu.uc.app.parkfinder.dto

import com.google.gson.annotations.SerializedName

data class Park(@SerializedName("Code") var code: String,
                @SerializedName("Name") var name: String) {

    override fun toString() = "$name"
}