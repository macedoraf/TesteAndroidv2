package br.com.rafael.main.ui.login.contracts

import br.com.rafael.main.base.BaseView
import br.com.rafael.main.ui.login.LoginModel

interface LoginActivityInput:BaseView {

    fun validateLoginSuccess(loginModelView: LoginModel.LoginViewModel)

    fun fetchUserData(user:String)
}