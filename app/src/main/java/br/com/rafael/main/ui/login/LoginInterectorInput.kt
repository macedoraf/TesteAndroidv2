package br.com.rafael.main.ui.login

import br.com.rafael.main.base.BaseInput

interface LoginInterectorInput: BaseInput {

    fun requestLogin(loginRequest: LoginModel.LoginRequest)
}