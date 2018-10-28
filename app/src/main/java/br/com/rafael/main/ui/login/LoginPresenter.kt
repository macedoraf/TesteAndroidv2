package br.com.rafael.main.ui.login

import android.content.Context
import br.com.rafael.main.base.BasePresenter
import br.com.rafael.main.extension.isNotNull
import br.com.rafael.main.model.User
import br.com.rafael.main.repository.preferences.UserPreferencesHelper
import br.com.rafael.main.ui.login.contracts.LoginActivityInput
import br.com.rafael.main.ui.login.contracts.LoginPresenterInput
import br.com.rafael.main.util.exceptions.ServiceException
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

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

        if(response.error.isNotNull()){
            outputActivity.onError(response.error!!.menssage)
            return
        }

        outputActivity.validateLoginSuccess(response.toLoginViewModel())
    }



    override fun getContext(): Context  = outputActivity.getContext()

}