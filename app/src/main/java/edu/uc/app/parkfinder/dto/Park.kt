package edu.uc.app.parkfinder.dto

import com.google.gson.annotations.SerializedName

data class Park(
    @SerializedName("Park Code") var code: String,
    @SerializedName("Park Name") var name: String
){
    override fun toString() = "$name $code"
}