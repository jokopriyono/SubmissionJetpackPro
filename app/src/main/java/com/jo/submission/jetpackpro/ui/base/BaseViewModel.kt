package com.jo.submission.jetpackpro.ui.base

import androidx.lifecycle.ViewModel
import com.jo.submission.jetpackpro.data.DataManager
import com.jo.submission.jetpackpro.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private lateinit var mNavigator: WeakReference<N>

    fun getNavigator() = mNavigator.get()!!

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
