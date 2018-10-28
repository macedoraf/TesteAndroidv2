package br.com.rafael.main.extension

import java.text.NumberFormat
import java.util.*


fun Float.toMoney():String {
    val format = NumberFormat.getCurrencyInstance(Locale("pt","BR"))
    return format.format(this)

}
