package br.com.rafael.main.di.components

import br.com.rafael.main.di.module.NetworkModule
import br.com.rafael.main.di.module.PreferencesModule
import br.com.rafael.main.ui.currency.CurrecyWorker
import br.com.rafael.main.ui.login.LoginWorker
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, PreferencesModule::class])
interface WorkerInjector {

    fun injectLoginWorker(loginWoker: LoginWorker)

    fun injectCurrecyWorker(currecyWorker: CurrecyWorker)


    @Component.Builder
    interface Builder {

        fun build():WorkerInjector

        fun networkModule(networkModule:NetworkModule):Builder

        fun userPreferencesModule(userPreferencesModule:PreferencesModule):Builder

    }
}