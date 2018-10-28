package br.com.rafael.main.ui.login

import br.com.rafael.main.base.BasePresenter
import br.com.rafael.main.model.User
import br.com.rafael.main.repository.preferences.UserPreferencesHelper
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class LoginPresenter(private val outputActivity: LoginActivityInput): BasePresenter(), LoginPresenterInput {

    @Inject
    lateinit var userPreferences: UserPreferencesHelper


    /**
     * Aqui eu usaria RxJava porém vou usar o AsynkTask
     * por não estar familiarizado com essa arquitetura
     */
    override fun presentLoginMetaData(response: LoginModel.LoginResponse) {

        doAsync {
            var result = true
            try {
                setUserIntoPreferences(response.user)
            }catch (err:Exception){
                err.printStackTrace()
                result = false

            }

            uiThread {
                outputActivity.validateLoginSuccess(result)

            }

        }




    }

     private fun setUserIntoPreferences (user:User){
        userPreferences.setAgency(user.agency)
        userPreferences.setBalance(user.balance)
        userPreferences.setUsuarioBankAccount(user.bankAccount)
        userPreferences.setUsuarioId(user.id)
        userPreferences.setUsuarioName(user.name)
    }
}