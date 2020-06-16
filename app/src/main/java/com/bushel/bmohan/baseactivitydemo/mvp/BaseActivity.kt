package com.bushel.bmohan.baseactivitydemo.mvp

import android.app.Application
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.bushel.bmohan.baseactivitydemo.R
import dagger.android.support.DaggerAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.dialog_loading.view.*
import javax.inject.Inject

abstract class BaseActivity<T : BasePresenter> : AppCompatActivity(), IBaseView {

    @Inject
    protected lateinit var app: Application

    @Inject
    protected lateinit var presenter: T

    private val progressDialogLazy = lazy {
        MaterialDialog(this).customView(R.layout.dialog_loading).cancelable(false)
            .cancelOnTouchOutside(false)
    }

    private val progressDialog by progressDialogLazy

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun hideProgress() {
        if (progressDialogLazy.isInitialized() && progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }

    override fun showProgress(content: String?) {
        progressDialog.getCustomView().tv_message.text =
            content ?: getString(R.string.progress_loading)
        progressDialog.show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(app, message, Toast.LENGTH_SHORT).show()
    }

    override fun showNetworkError(message: String, showRetry: Boolean) {
        MaterialDialog(this).show {
            title(R.string.dialog_error_title)
            message(text = message)
            positiveButton(R.string.dialog_ok)
        }
    }

}