package br.com.rafael.main.ui.login

import android.content.Context
import br.com.rafael.main.base.BaseInterector
import br.com.rafael.main.ui.login.contracts.LoginInterectorInput
import br.com.rafael.main.ui.login.contracts.LoginPresenterInput
import br.com.rafael.main.ui.login.contracts.LoginWorkerInput
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginInterector(private val presenter: LoginPresenterInput):BaseInterector(),
    LoginInterectorInput {

     val loginWorkerInput by lazy<LoginWorkerInput> { LoginWorker()}

    override fun requestLogin(loginRequest: LoginModel.LoginRequest) {
        presenter.showLoading()
        addSubscription(loginWorkerInput.getLoginFromService(loginRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate{presenter.hideLoading()}
            .subscribe({presenter.presentLoginMetaData(it)},{presenter.onError(it)}))


    }

}