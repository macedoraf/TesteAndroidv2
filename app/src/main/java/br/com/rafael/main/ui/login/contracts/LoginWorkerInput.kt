package br.com.rafael.main.ui.login.contracts

import br.com.rafael.main.ui.login.LoginModel
import io.reactivex.Observable

interface LoginWorkerInput {

    fun getLoginFromService(request: LoginModel.LoginRequest): Observable<LoginModel.LoginResponse>

    fun setLoginIntoPreferences(loginResponse:LoginModel.LoginResponse)

    fun setUsernameIntoPreferences(username:String)

    fun fetchUserData():String
}