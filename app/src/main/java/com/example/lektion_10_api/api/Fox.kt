package com.example.lektion_10_api.api

import com.google.gson.annotations.SerializedName

// Template from API Object
class Fox {

    @SerializedName("image")    // Change Name for API key-value-pairs
    val myImage : String = ""

    @SerializedName("link")
    val myLink : String = ""

    override fun toString(): String {
        return "Fox(myImage='$myImage', myLink='$myLink')"
    }

}