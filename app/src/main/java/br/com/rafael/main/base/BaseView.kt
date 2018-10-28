package br.com.rafael.main.base

import android.content.Context

interface BaseView {

    fun getContext():Context

    fun onError(err:Throwable)

    fun showLoading()

    fun hideLoading()
}