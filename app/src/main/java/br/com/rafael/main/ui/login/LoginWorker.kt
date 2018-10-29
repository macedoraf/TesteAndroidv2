package br.com.rafael.main.ui.login

import android.content.Context
import br.com.rafael.main.base.BaseWorker
import br.com.rafael.main.extension.isNotNull
import br.com.rafael.main.model.User
import br.com.rafael.main.repository.network.API
import br.com.rafael.main.repository.preferences.UserPreferencesHelperImpl
import br.com.rafael.main.ui.login.contracts.LoginWorkerInput
import io.reactivex.Observable
import javax.inject.Inject

class LoginWorker(context: Context): BaseWorker(context), LoginWorkerInput {


    @Inject
    lateinit var userPreferences: UserPreferencesHelperImpl

    @Inject
    lateinit var api:API


    override fun setLoginIntoPreferences(loginResponse: LoginModel.LoginResponse) {
        if(loginResponse.user.isNotNull()) setUserIntoPreferences(loginResponse.user)

    }

    override fun getLoginFromService(request: LoginModel.LoginRequest): Observable<LoginModel.LoginResponse> {
        return api.getLogin(request.login,request.password)
    }

    override fun fetchUserData(): String = userPreferences.getUsername()

    override fun setUsernameIntoPreferences(username: String) {
        userPreferences.setUsername(username)
    }


    private fun setUserIntoPreferences (user: User){
        userPreferences.setAgency(user.agency)
        userPreferences.setBalance(user.balance)
        userPreferences.setUsuarioBankAccount(user.bankAccount)
        userPreferences.setUsuarioId(user.id)
        userPreferences.setUsuarioName(user.name)
    }
}