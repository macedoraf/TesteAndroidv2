package br.com.rafael.main.ui.login

import br.com.rafael.main.base.BaseInterector
import br.com.rafael.main.ui.login.contracts.LoginInterectorInput
import br.com.rafael.main.ui.login.contracts.LoginPresenterInput
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginInterector(private val presenter: LoginPresenterInput):BaseInterector(),
    LoginInterectorInput {

    private val loginWorkerInput by lazy{ LoginWorker(presenter.getContext())}

    override fun requestLogin(loginRequest: LoginModel.LoginRequest) {
        presenter.showLoading()
        addSubscription(loginWorkerInput.getLoginFromService(loginRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate{presenter.hideLoading()}
            .subscribe({
                presenter.presentLoginMetaData(it)
                loginWorkerInput.setLoginIntoPreferences(it)
            },{
                it.printStackTrace()
                presenter.onError(it.message!!)}))


    }

    override fun fetchUserData() {
        presenter.fetchUserData(loginWorkerInput.fetchUserData())
    }

}