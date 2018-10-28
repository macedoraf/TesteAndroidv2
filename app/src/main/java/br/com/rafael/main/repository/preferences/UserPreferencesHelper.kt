package br.com.rafael.main.repository.preferences

interface UserPreferencesHelper {

    fun setUsuarioId(id:Long)

    fun getUsuarioId():Long

    fun setUsuarioName(name:String)

    fun getUsuarioName():String

    fun setUsuarioBankAccount(bankAccount:String)

    fun getUsuarioBankAccount():String

    fun setAgency(agency:String)

    fun getAgency():String

    fun setBalance(balance:Float)

    fun getBalance():Float
}