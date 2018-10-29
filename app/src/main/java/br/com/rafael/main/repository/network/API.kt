package br.com.rafael.main.repository.network

import br.com.rafael.main.ui.currency.StatmentModel
import br.com.rafael.main.ui.login.LoginModel
import io.reactivex.Observable
import retrofit2.http.*

interface API {

    @FormUrlEncoded()
    @POST("login")
    fun getLogin(@Field("user") user:String,@Field("password") password:String):Observable<LoginModel.LoginResponse>

    @GET("statements/{id}")
    fun getStatmentList(@Path("id") id:Long):Observable<StatmentModel.StatmentResponse>
}