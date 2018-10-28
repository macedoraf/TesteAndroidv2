package br.com.rafael.main.ui.currency.contracts

import br.com.rafael.main.base.BaseView
import br.com.rafael.main.ui.currency.StatmentModel

interface CurrencyActivityInput: BaseView {

    fun fetchStatmentViewModelList(listStatmentViewModel: List<StatmentModel.StatmentViewModel>)

    fun getStatmentViewModelList():List<StatmentModel.StatmentViewModel>

}
