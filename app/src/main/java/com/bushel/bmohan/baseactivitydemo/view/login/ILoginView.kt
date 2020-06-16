package com.bushel.bmohan.baseactivitydemo.view.login

interface ILoginView {
    fun onLoginSuccess()
    fun onInvalidCredentials()
    fun hideProgress()
    fun showSuccess(message: String)
    fun showNetworkError(message: String, showRetry: Boolean = false)
}