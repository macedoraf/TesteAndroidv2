package br.com.rafael.main.ui.currency

import br.com.rafael.main.base.BaseInterector
import br.com.rafael.main.ui.currency.contracts.CurrencyInterectorInput
import br.com.rafael.main.ui.currency.contracts.CurrencyPresenterInput
import br.com.rafael.main.ui.currency.contracts.CurrencyWorkerInput
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CurrencyInterector(private val presenter: CurrencyPresenterInput):BaseInterector(),
    CurrencyInterectorInput {

    private val currencyWorkerInput by lazy<CurrencyWorkerInput> { CurrecyWorker(presenter.getContext())}

    override fun fetchStatementList() {
        presenter.showLoading()
        addSubscription(currencyWorkerInput.fetchStatementList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate{presenter.hideLoading()}
            .subscribe({presenter.fetchStatementViewModelList(it)},{
                it.printStackTrace()
                presenter.onError(it.message!!)}))


    }


}