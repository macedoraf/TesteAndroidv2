package br.com.rafael.main.repository.network

import br.com.rafael.main.ui.login.LoginModel
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API {

    @FormUrlEncoded()
    @POST("login")
    fun getLogin(@Field("user") user:String,@Field("password") password:String):Observable<LoginModel.LoginResponse>
}