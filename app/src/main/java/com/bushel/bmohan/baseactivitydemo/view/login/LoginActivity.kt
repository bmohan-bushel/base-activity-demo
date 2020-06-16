package com.bushel.bmohan.baseactivitydemo.view.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.bushel.bmohan.baseactivitydemo.R
import com.bushel.bmohan.baseactivitydemo.mvp.BaseActivity
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), ILoginView {

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    fun init() {
        bt_login.setOnClickListener {
            disableErrors()
            presenter.login(et_username.text.toString(), et_password.text.toString())
        }
    }

    private fun disableErrors() {
        vg_username_layout.isErrorEnabled = false
        vg_password_layout.isErrorEnabled = false
    }

    private fun enableErrors() {
        vg_username_layout.error = getString(R.string.username_error)
        vg_password_layout.error = getString(R.string.password_error)
        vg_username_layout.isErrorEnabled = true
        vg_password_layout.isErrorEnabled = true
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
    }

    override fun onInvalidCredentials() {
        enableErrors()
    }
}