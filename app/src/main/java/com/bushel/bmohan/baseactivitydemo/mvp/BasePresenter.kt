package com.bushel.bmohan.baseactivitydemo.mvp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class BasePresenter {

    open fun retry() {
        //NO-OP
    }

    open fun onPause() {
        presenterScope.cancel()
    }

    open fun onResume() {
        //NO-OP
    }

    open fun onFinish() {
        presenterScope.cancel()
    }
}

val presenterScope: CoroutineScope
    get() {
        return CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    }