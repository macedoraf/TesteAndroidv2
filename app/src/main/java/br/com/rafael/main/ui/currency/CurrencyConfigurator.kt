package br.com.rafael.main.ui.currency

import br.com.rafael.main.extension.isNull

enum class CurrencyConfigurator {
    INSTANCE;

    fun cofigure(activity: CurrencyActivity){

        val currencyRouter = CurrencyRouter(activity)

        val currencyPresenter = CurrencyPresenter(activity)

        val currencyInterector = CurrencyInterector(currencyPresenter)

        if(activity.interectorInput.isNull()) activity.interectorInput = currencyInterector

        if (activity.currencyRouter.isNull()) activity.currencyRouter = currencyRouter

    }
}