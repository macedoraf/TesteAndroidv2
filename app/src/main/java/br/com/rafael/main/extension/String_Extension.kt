package br.com.rafael.main.extension

import android.util.Patterns
import java.util.regex.Pattern

fun String.isEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isCPF(): Boolean {

    if (this.isEmpty()) return false

    val numbers = arrayListOf<Int>()

    this.filter { it.isDigit() }.forEach {
        numbers.add(it.toString().toInt())
    }

    if (numbers.size != 11) return false

    //repeticao
    (0..9).forEach { n ->
        val digits = arrayListOf<Int>()
        (0..10).forEach { digits.add(n) }
        if (numbers == digits) return false
    }

    //digito 1
    val dv1 = ((0..8).sumBy { (it + 1) * numbers[it] }).rem(11).let {
        if (it >= 10) 0 else it
    }

    val dv2 = ((0..8).sumBy { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
        if (it >= 10) 0 else it
    }

    return numbers[9] == dv1 && numbers[10] == dv2
}

fun String.hasOneUppercase():Boolean {
    val pattern = Pattern.compile("[A-z]")
    val matcher = pattern.matcher(this)
    val aboolean = matcher.find()
    return aboolean
}

fun String.hasOneNumber():Boolean{
    val pattern = Pattern.compile("")
    val matcher = pattern.matcher(this)
    val aboolean = matcher.find()
    return aboolean
}

fun String.hasOneSpecialCaracter():Boolean{
    val pattern = Pattern.compile("\\W")
    val matcher = pattern.matcher(this)
    val aboolean = matcher.find()
    return aboolean

}