package br.com.rafael.main.ui.login

import android.content.Context
import br.com.rafael.main.base.BaseInterector
import br.com.rafael.main.model.User

class LoginInterector(private val presenter: LoginPresenterInput):BaseInterector(),LoginInterectorInput  {


    override fun requestLogin(loginRequest: LoginModel.LoginRequest) {
        //TODO: Realiza chamada para API e chama a presenter passando o resultado

        presenter.presentLoginMetaData(LoginModel.LoginResponse(User(0,"","","",0F)))
    }

    override fun getContext(): Context  = presenter.getContext()
}