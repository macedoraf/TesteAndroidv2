package br.com.rafael.main.model

import android.util.Log
import com.google.gson.annotations.SerializedName

data class ErrorService(@SerializedName(value = "code")val code:Int, @SerializedName(value = "message")val menssage:String){

    fun toErrorLog(tag:String):String{
        val errorFormated = "[$code] $menssage"
        Log.e(tag,errorFormated)
        return errorFormated
    }
}
