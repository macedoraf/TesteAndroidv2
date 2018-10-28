package br.com.rafael.main.ui.currency.contracts

import br.com.rafael.main.base.BaseView
import br.com.rafael.main.ui.currency.StatmentModel


interface CurrencyPresenterInput: BaseView {


    fun fetchStatementViewModelList(response: StatmentModel.StatmentResponse)


}