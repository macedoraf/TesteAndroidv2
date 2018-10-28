package br.com.rafael.main.ui.login

import br.com.rafael.main.base.BaseInput


interface LoginPresenterInput: BaseInput {
    fun presentLoginMetaData(response:LoginModel.LoginResponse)


}