package br.com.rafael.main.ui.currency

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Adapter
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import br.com.rafael.main.extension.isNotNull
import br.com.rafael.main.extension.isNull
import br.com.rafael.main.extension.toMoney
import br.com.rafael.main.ui.currency.adapter.StatmentAdapter
import br.com.rafael.main.ui.currency.contracts.CurrencyActivityInput
import br.com.rafael.main.ui.currency.contracts.CurrencyInterectorInput
import br.com.rafael.main.ui.currency.contracts.CurrencyRouterInput
import br.com.rafael.main.ui.login.LoginModel
import br.com.rafael.main.util.KEY_LOGIN_TO_CURRENCY
import br.com.rafael.testeandroidv2resourcerafael.R

class CurrencyActivity : AppCompatActivity(), CurrencyActivityInput {


    private lateinit var lblAccountAgency:TextView
    private lateinit var lblValueCurrency:TextView
    private lateinit var recyclerViewCurrency:RecyclerView
    private lateinit var adapter:StatmentAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var listStatmentViewModel:MutableList<StatmentModel.StatmentViewModel>

    var interectorInput:CurrencyInterectorInput? = null

    var currencyRouter: CurrencyRouterInput? = null

    val userViewModel by lazy { this.intent.extras?.getSerializable(KEY_LOGIN_TO_CURRENCY) as LoginModel.LoginViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
        CurrencyConfigurator.INSTANCE.cofigure(this)
        listStatmentViewModel = mutableListOf()
        initViews()
        setupRecyclerView()
        setupAdapter()
        initValues()


    }

    private fun initValues() {
        if(userViewModel.isNull())
            return

        lblAccountAgency.text = "${userViewModel.agency} / ${userViewModel.bankAccount}"
        lblValueCurrency.text = "${userViewModel.balance.toMoney()}"
    }

    override fun onResume() {
        super.onResume()
        fetchStatmentViewModelList()


    }

    private fun fetchStatmentViewModelList() {
       interectorInput?.fetchStatementList()
    }

    private fun setupAdapter() {
        adapter = StatmentAdapter(this)
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


    override fun getStatmentViewModelList(): List<StatmentModel.StatmentViewModel> = this.listStatmentViewModel


    override fun getContext(): Context  = this

    override fun onError(err: String) {
       Toast.makeText(this,err,Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    fun updateAdapter(){
        adapter.notifyDataSetChanged()
    }


    override fun fetchStatmentViewModelList(listStatmentViewModel: List<StatmentModel.StatmentViewModel>) {
        this.listStatmentViewModel.clear()
        this.listStatmentViewModel.addAll(listStatmentViewModel)
        this.updateAdapter()
    }


}
