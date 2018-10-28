package br.com.rafael.main.ui.login

import br.com.rafael.main.base.BaseInput

interface LoginActivityInput: BaseInput {

    fun validateLoginSuccess(isTrue:Boolean)
}