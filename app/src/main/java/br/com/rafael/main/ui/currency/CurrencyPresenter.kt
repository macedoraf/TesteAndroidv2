package br.com.rafael.main.ui.currency

import android.content.Context
import br.com.rafael.main.base.BasePresenter
import br.com.rafael.main.ui.currency.contracts.CurrencyActivityInput
import br.com.rafael.main.ui.currency.contracts.CurrencyPresenterInput

class CurrencyPresenter(private val outputActivity: CurrencyActivityInput) :
    CurrencyPresenterInput, BasePresenter() {


    override fun fetchStatementViewModelList(response: StatmentModel.StatmentResponse) {
        if(response.error.code > 0){
            outputActivity.onError(response.error.toErrorLog(TAG))
            return
        }

        outputActivity.fetchStatmentViewModelList(response.toModelView())
    }

    override fun getContext(): Context = outputActivity.getContext()

    override fun onError(err: String) {
        outputActivity.onError(err)
    }

    override fun showLoading() {
        outputActivity.showLoading()
    }

    override fun hideLoading() {
        outputActivity.hideLoading()
    }

}
