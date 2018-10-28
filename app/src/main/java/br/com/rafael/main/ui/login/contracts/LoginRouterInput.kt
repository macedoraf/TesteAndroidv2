package br.com.rafael.main.ui.login.contracts

import br.com.rafael.main.ui.login.LoginModel

interface LoginRouterInput {

    fun showCurrencyScreen(loginViewModel: LoginModel.LoginViewModel?)
}