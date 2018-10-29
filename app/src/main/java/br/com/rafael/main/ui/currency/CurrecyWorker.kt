package br.com.rafael.main.ui.currency

import android.content.Context
import br.com.rafael.main.base.BaseWorker
import br.com.rafael.main.repository.network.API
import br.com.rafael.main.ui.currency.contracts.CurrencyWorkerInput
import io.reactivex.Observable
import javax.inject.Inject

class CurrecyWorker(context: Context) : CurrencyWorkerInput, BaseWorker(context) {


    @Inject
    lateinit var api: API


    override fun fetchStatementList(id:Long): Observable<StatmentModel.StatmentResponse> {
        return api.getStatmentList(id)
    }

}
