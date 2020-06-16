package com.bushel.bmohan.baseactivitydemo.view.login

import com.bushel.bmohan.baseactivitydemo.data.service.ILoginService
import com.bushel.bmohan.baseactivitydemo.mvp.BasePresenter
import com.bushel.bmohan.baseactivitydemo.mvp.presenterScope
import com.myriadmobile.fargoeventsboard.data.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val view: ILoginView, private val service: ILoginService) : BasePresenter() {

    private lateinit var username: String
    private lateinit var password: String

    fun login(username: String, password: String) {
        if (validateCredentials(username, password)) {
            this.username = username
            this.password = password
            presenterScope.launch {
                val result = service.login(username, password)

                when (result) {
                    is Result.Success -> view.onLoginSuccess()
                    is Result.Error -> view.onInvalidCredentials()
                    is Result.Exception -> view.showNetworkError(result.exception.message.toString())
                }
            }
        } else {
            view.onInvalidCredentials()
        }
    }

    override fun retry() {
        login(username, password)
    }

    /**
     * Validates provided credentials
     *
     * @param username The entered username
     * @param password The entered password
     */
    private fun validateCredentials(username: String, password: String): Boolean {
        return username.matches(Regex("""^([\w\-]+)@([\w\-]+)((\.(\w){2,3})+)$""")) && password.length > 4
    }
}