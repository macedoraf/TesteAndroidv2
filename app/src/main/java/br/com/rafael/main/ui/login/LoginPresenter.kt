package br.com.rafael.main.ui.login

import android.content.Context
import br.com.rafael.main.base.BasePresenter
import br.com.rafael.main.ui.login.contracts.LoginActivityInput
import br.com.rafael.main.ui.login.contracts.LoginPresenterInput

class LoginPresenter(private val outputActivity: LoginActivityInput): BasePresenter(),
    LoginPresenterInput {

    override fun onError(err:String) {
        outputActivity.onError(err)
    }

    override fun showLoading() {
        outputActivity.showLoading()
    }

    override fun hideLoading() {
        outputActivity.hideLoading()
    }

    override fun presentLoginMetaData(response: LoginModel.LoginResponse) {

        if(response.error.code > 0){
            outputActivity.onError(response.error.toErrorLog(TAG))
            return
        }

        outputActivity.validateLoginSuccess(response.toLoginViewModel())
    }


    override fun fetchUserData(user: String) {
        outputActivity.fetchUserData(user)
    }



    override fun getContext(): Context  = outputActivity.getContext()

}