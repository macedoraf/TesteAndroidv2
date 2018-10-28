package br.com.rafael.main.ui.currency.contracts

import br.com.rafael.main.ui.currency.StatmentModel
import io.reactivex.Observable

interface CurrencyWorkerInput {

    fun fetchStatementList():Observable<StatmentModel.StatmentResponse>
}