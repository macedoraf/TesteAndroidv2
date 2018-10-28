package br.com.rafael.main.model

import com.google.gson.annotations.SerializedName

data class ErrorService(@SerializedName(value = "error")val code:Int, @SerializedName(value = "message")val menssage:String)
