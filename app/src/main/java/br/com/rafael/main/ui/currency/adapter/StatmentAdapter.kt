package br.com.rafael.main.ui.currency.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.rafael.main.ui.currency.adapter.holder.StatmentHolder
import br.com.rafael.main.ui.currency.contracts.CurrencyActivityInput
import br.com.rafael.testeandroidv2resourcerafael.R


class StatmentAdapter(private val currencyActivityInput: CurrencyActivityInput) : RecyclerView.Adapter<StatmentHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): StatmentHolder =
        StatmentHolder(LayoutInflater.from(p0.context).inflate(R.layout.list_item_currency, p0, false))


    override fun getItemCount(): Int = currencyActivityInput.getStatmentViewModelList().size


    override fun onBindViewHolder(holder: StatmentHolder, position: Int) {
        holder.bind(currencyActivityInput.getStatmentViewModelList()[position])
    }
}