package edu.uc.app.parkfinder.dto

import com.google.gson.annotations.SerializedName

data class Park(@SerializedName("Location Name") var name: String,
                @SerializedName("Location Number") var number: String) {

    override fun toString() = "$number $name"
}