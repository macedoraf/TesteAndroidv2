package br.com.rafael.main.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "userId")val id:Long,
    @SerializedName(value = "name")val name:String,
    @SerializedName(value = "bankAccount")val bankAccount:String,
    @SerializedName(value = "agency")val agency:String,
    @SerializedName(value = "balance")val balance:Float
) {
}