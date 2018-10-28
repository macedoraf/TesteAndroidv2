package br.com.rafael.main.ui.login.contracts

import br.com.rafael.main.ui.login.LoginModel

interface LoginInterectorInput {

    fun requestLogin(loginRequest: LoginModel.LoginRequest)
}