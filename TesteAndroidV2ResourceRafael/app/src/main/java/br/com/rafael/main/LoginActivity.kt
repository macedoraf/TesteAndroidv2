package br.com.rafael.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.rafael.testeandroidv2resourcerafael.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        intent  = Intent(this,CurrencyActivity::class.java)
        startActivity(intent)
    }
}
