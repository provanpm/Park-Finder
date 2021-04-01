package edu.uc.app.parkfinder.dto

import com.google.gson.annotations.SerializedName

data class Park(@SerializedName("Location Number") var code: String, @SerializedName("Location Name") var name: String){
    override fun toString() = "$name $code"
}