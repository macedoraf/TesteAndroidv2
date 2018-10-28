package br.com.rafael.main.base

import android.content.Context
import br.com.rafael.main.di.components.DaggerWorkerInjector
import br.com.rafael.main.di.components.WorkerInjector
import br.com.rafael.main.di.module.NetworkModule
import br.com.rafael.main.di.module.PreferencesModule
import br.com.rafael.main.ui.login.LoginWorker

abstract class BaseWorker(context: Context) {

        private val injector:WorkerInjector = DaggerWorkerInjector
            .builder()
            .networkModule(NetworkModule)
            .userPreferencesModule(PreferencesModule(context))
            .build()

    init {
        inject()
    }

    /**
     * Toda vez que criar um worker novo deve criar um método novo para injetalo e fazer o switch aqui para injetar
     * a classe certa com o método certo
     */
    private fun inject() {
        when(this){
            is LoginWorker -> injector.injectLoginWorker(this)
        }
    }

}
