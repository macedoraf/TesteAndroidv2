package br.com.rafael.main.ui.login.contracts

import br.com.rafael.main.base.BaseView

interface LoginActivityInput:BaseView {

    fun validateLoginSuccess(isTrue:Boolean)
}