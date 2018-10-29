package br.com.rafael.main.ui.login

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import br.com.rafael.main.base.BaseRouter
import br.com.rafael.main.ui.currency.CurrencyActivity
import br.com.rafael.main.ui.login.contracts.LoginRouterInput
import br.com.rafael.main.util.KEY_LOGIN_TO_CURRENCY

/**
 * Interface para inputar os dados para o router
 */

class LoginRouter(private val activity:LoginActivity): BaseRouter(),
    LoginRouterInput {


    override fun showCurrencyScreen(loginViewModel: LoginModel.LoginViewModel?) {
        showNextScreen(passDataToNextScreen(Intent(activity, CurrencyActivity::class.java),loginViewModel,
            KEY_LOGIN_TO_CURRENCY))

    }


    private fun showNextScreen(intent: Intent){
        activity.startActivity(intent)
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(FLAG_ACTIVITY_CLEAR_TASK)
        activity.finish()
    }




}