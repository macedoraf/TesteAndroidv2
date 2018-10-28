package br.com.rafael.main.ui.login

import br.com.rafael.main.ui.login.contracts.LoginWorkerInput
import io.reactivex.Observable

class LoginWorker: LoginWorkerInput {

    override fun getLoginFromService(request: LoginModel.LoginRequest): Observable<LoginModel.LoginResponse> {

    }
}