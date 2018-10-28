package br.com.rafael.main.ui.login

import android.content.Context
import android.content.Intent
import br.com.rafael.main.base.BaseRouter
import br.com.rafael.main.extension.isNotNull
import br.com.rafael.main.ui.currency.CurrencyActivity
import java.io.Serializable

/**
 * Interface para inputar os dados para o router
 */

class LoginRouter(private val activity:LoginActivity): BaseRouter(), LoginRouterInput {


    override fun showCurrencyScreen() {
        showNextScreen(Intent(activity, CurrencyActivity::class.java))
    }

    private fun showNextScreen(intent: Intent){
        activity.startActivity(passDataToNextScreen(intent,null,null))
    }

    private fun <T:Serializable> passDataToNextScreen(intent:Intent ,anyObject:T?,key:String?):Intent{
        if(anyObject.isNotNull() && key.isNotNull())
        intent.putExtra(key,anyObject)
        return intent
    }

    override fun getContext(): Context  = activity.baseContext


}