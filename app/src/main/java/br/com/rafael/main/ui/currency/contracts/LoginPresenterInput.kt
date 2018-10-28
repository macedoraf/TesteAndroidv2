package br.com.rafael.main.ui.login.contracts

import br.com.rafael.main.base.BaseView
import br.com.rafael.main.ui.login.LoginModel


interface LoginPresenterInput: BaseView {
    fun presentLoginMetaData(response: LoginModel.LoginResponse)

    fun setInitializeUserData(user:String)


}