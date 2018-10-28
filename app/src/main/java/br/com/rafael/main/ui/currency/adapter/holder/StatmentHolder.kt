package br.com.rafael.main.ui.currency.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import br.com.rafael.main.extension.toMoney
import br.com.rafael.main.ui.currency.StatmentModel
import br.com.rafael.testeandroidv2resourcerafael.R

class StatmentHolder(itemView: View,
                     val lblDescricao:TextView = itemView.findViewById(R.id.lbl_descricao),
                     val lblData:TextView = itemView.findViewById(R.id.lbl_data),
                     val lblValor:TextView = itemView.findViewById(R.id.lbl_valor)) : RecyclerView.ViewHolder(itemView) {

    fun bind(statment: StatmentModel.StatmentViewModel){
        lblDescricao.text = statment.des
        lblData.text = statment.date
        lblValor.text = statment.value.toMoney()
    }



}
