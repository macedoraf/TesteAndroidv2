package br.com.rafael.main.ui.login

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.rafael.testeandroidv2resourcerafael.R

class LoginActivity : AppCompatActivity(), LoginActivityInput {


    lateinit var router:LoginRouter
    lateinit var interector:LoginInterector

    override fun validateLoginSuccess(isTrue: Boolean) {
        if(isTrue) showCurrencyScreen() else showLoginError()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        LoginConfigurator.INSTANCE.cofigure(this)
    }


    private fun showCurrencyScreen(){
        router.showCurrencyScreen()
    }

    private fun showLoginError() {
        Toast.makeText(this,"Erro ao realizar login",Toast.LENGTH_LONG).show()
    }

    override fun getContext(): Context  = baseContext

}
