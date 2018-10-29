package br.com.rafael.main.repository.preferences

import android.content.Context
import android.content.SharedPreferences

class UserPreferencesHelperImpl(context: Context,preferencesKey:String,
                                private val sharedPreferences: SharedPreferences = context.
                                getSharedPreferences(preferencesKey,Context.MODE_PRIVATE)): UserPreferencesHelper {


    private val USER_ID = "USER_ID"
    private val USER_NAME = "USER_NAME"
    private val USER_BANK_ACCOUNT = "USER_BANK_ACCOUNT"
    private val USER_AGENCY = "USER_AGENCY"
    private val USER_BALANCE = "USER_BALANCE"
    private val USER_USERNAME = "USER_USERNAME"


    override fun setUsername(username: String) {
        putValue(USER_USERNAME,username)
    }

    override fun getUsername(): String {
        return sharedPreferences.getString(USER_USERNAME,"")!!
    }



    override fun setUsuarioId(id: Long) {
        putValue(USER_ID,id)
    }

    override fun getUsuarioId(): Long = sharedPreferences.getLong(USER_ID,0)

    override fun setUsuarioName(name: String) {
        putValue(USER_NAME,name)
    }

    override fun getUsuarioName(): String = sharedPreferences.getString(USER_NAME,"")!!

    override fun setUsuarioBankAccount(bankAccount: String) {
        putValue(USER_BANK_ACCOUNT,bankAccount)
    }

    override fun getUsuarioBankAccount(): String = sharedPreferences.getString(USER_BANK_ACCOUNT,"")!!

    override fun setAgency(agency: String) {
        putValue(USER_AGENCY,agency)
    }

    override fun getAgency(): String  = sharedPreferences.getString(USER_AGENCY,"")!!

    override fun setBalance(balance: Float) {
        putValue(USER_BALANCE,balance)
    }

    override fun getBalance(): Float = sharedPreferences.getFloat(USER_BALANCE,0F)


    private fun putValue(key:String,value:Any){
        val edit = sharedPreferences.edit()
        edit.clear()
        when(value){

            is Boolean ->{
                edit.putBoolean(key,value)
            }

            is Long ->{
                edit.putLong(key,value)
            }

            is Float ->{
                edit.putFloat(key,value)
            }

            is String ->{
                edit.putString(key,value)
            }

            is Int ->{
                edit.putInt(key,value)
            }
        }

        edit.apply()

    }
}