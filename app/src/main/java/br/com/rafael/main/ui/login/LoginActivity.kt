package br.com.rafael.main.ui.login

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.rafael.main.ui.login.contracts.LoginActivityInput
import br.com.rafael.testeandroidv2resourcerafael.R

class LoginActivity : AppCompatActivity(), LoginActivityInput {

    var router:LoginRouter? = null

    var interector:LoginInterector? = null

    lateinit var btnLogin:Button

    lateinit var edtUser:EditText

    lateinit var edtPassword:EditText

    override fun validateLoginSuccess(loginModelView: LoginModel.LoginViewModel) {
        showCurrencyScreen(loginModelView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        LoginConfigurator.INSTANCE.cofigure(this)
        initView()
        setListeners()
    }



    private fun initView() {
        edtUser = findViewById(R.id.edt_user)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btnLogin)

    }

    private fun setListeners() {
        btnLogin.setOnClickListener {
            interector?.requestLogin(LoginModel.LoginRequest(edtUser.text.toString(),edtPassword.text.toString()))
        }
    }


    private fun showCurrencyScreen(loginMovelView: LoginModel.LoginViewModel){
        router?.showCurrencyScreen(loginMovelView)
    }

    override fun getContext(): Context  = baseContext

    override fun onError(err: String) {
        Toast.makeText(this,err,Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
       //TODO LOADING SHOW
    }

    override fun hideLoading() {
        //TODO LOADING HIDE
    }

}
