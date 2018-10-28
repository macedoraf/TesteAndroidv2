package br.com.rafael.main.ui.login

import br.com.rafael.main.extension.isNull

enum class LoginConfigurator {
    INSTANCE;

    fun cofigure(activity: LoginActivity){

        val loginRouter = LoginRouter(activity)

        val loginPresenter = LoginPresenter(activity)

        val loginInterector = LoginInterector(loginPresenter)

        if(activity.interector.isNull()) activity.interector = loginInterector

        if (activity.router.isNull()) activity.router = loginRouter

    }
}