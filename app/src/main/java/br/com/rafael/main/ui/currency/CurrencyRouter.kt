package br.com.rafael.main.ui.currency

import br.com.rafael.main.ui.currency.contracts.CurrencyRouterInput
import br.com.rafael.main.ui.login.LoginActivity
import org.jetbrains.anko.startActivity

class CurrencyRouter(private val activity: CurrencyActivity):CurrencyRouterInput {

    override fun showLoginScreen() {
        activity.startActivity<LoginActivity>()
        activity.finish()
    }


}
