package br.com.rafael.main.ui.login

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import br.com.rafael.main.extension.*
import br.com.rafael.main.ui.login.contracts.LoginActivityInput
import br.com.rafael.main.ui.currency.contracts.CurrencyInterectorInput
import br.com.rafael.main.ui.login.contracts.LoginInterectorInput
import br.com.rafael.main.ui.login.contracts.LoginRouterInput
import br.com.rafael.testeandroidv2resourcerafael.R

class LoginActivity : AppCompatActivity(), LoginActivityInput {



    var router:LoginRouterInput? = null

    var interector: LoginInterectorInput? = null

    private lateinit var btnLogin:Button

    private lateinit var edtUser:EditText

    private lateinit var edtPassword:EditText

    private lateinit var progressBar:ProgressBar

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

    override fun onResume() {
        super.onResume()
        setInitializeUserData()

    }

    private fun setInitializeUserData() {
        interector?.fetchUserData()
    }


    private fun initView() {
        edtUser = findViewById(R.id.edt_user)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btnLogin)
        progressBar = findViewById(R.id.progress_bar)

    }

    private fun setListeners() {
        btnLogin.setOnClickListener {
            actionOnClickLogin()
        }
    }


    private fun isValidForm(user:String, password:String): Boolean {


        if(!user.isCPF() && !user.isEmail()){
            Toast.makeText(this,R.string.alert_valid_email_cpf,Toast.LENGTH_LONG).show()
            return false
        }

        if(!password.hasOneNumber() || !password.hasOneSpecialCaracter() || !password.hasOneUppercase()){
            Toast.makeText(this,R.string.alert_valid_password,Toast.LENGTH_LONG).show()
            return false
        }
        return true

    }

    private fun actionOnClickLogin() {
        val user = edtUser.text.toString()
        val password = edtPassword.text.toString()
        if (isValidForm(user, password))
            interector?.requestLogin(LoginModel.LoginRequest(user, password))
    }



    private fun showCurrencyScreen(loginModelView: LoginModel.LoginViewModel){
        router?.showCurrencyScreen(loginModelView) }

    override fun getContext(): Context  = baseContext

    override fun onError(err: String) {
        Toast.makeText(this,err,Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun fetchUserData(user: String) {
        edtUser.setText(user)
    }

}
