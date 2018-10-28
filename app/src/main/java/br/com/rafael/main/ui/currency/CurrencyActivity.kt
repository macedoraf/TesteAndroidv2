package br.com.rafael.main.ui.currency

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import android.widget.TextView
import br.com.rafael.main.ui.currency.adapter.CurrencyAdapter
import br.com.rafael.testeandroidv2resourcerafael.R

class CurrencyActivity : AppCompatActivity() {

    private lateinit var lblAccountAgency:TextView
    private lateinit var lblValueCurrency:TextView
    private lateinit var recyclerViewCurrency:RecyclerView
    private lateinit var adapter:CurrencyAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)

        initViews()
        setupRecyclerView()
        setupAdapter()


    }

    override fun onResume() {
        super.onResume()

    }

    private fun setupAdapter() {
        //TODO init adapter
        recyclerViewCurrency.adapter = adapter

    }

    private fun setupRecyclerView() {
        recyclerViewCurrency.layoutManager = LinearLayoutManager(this)
    }

    private fun initViews() {
        lblAccountAgency = findViewById(R.id.lbl_account_agency)
        lblValueCurrency = findViewById(R.id.lbl_value_currency)
        recyclerViewCurrency = findViewById(R.id.rv_currency)
        progressBar = findViewById(R.id.progress_bar)


    }


}
