package com.bushel.bmohan.baseactivitydemo.mvp

interface IBaseView {
    fun showProgress(content: String? = null)
    fun hideProgress()
    fun showSuccess(message: String)
    fun showNetworkError(message: String, showRetry: Boolean = false)
}