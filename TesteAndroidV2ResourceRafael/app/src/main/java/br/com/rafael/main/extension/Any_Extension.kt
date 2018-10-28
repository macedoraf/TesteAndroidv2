package br.com.rafael.main.extension

fun Any?.isNull():Boolean{
    return this == null
}

fun Any?.isNotNull():Boolean{
    return this != null
}