package com.jo.submission.jetpackpro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelProviderFactory<V>(private val viewModel: V) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((viewModel as Any).javaClass))
            return viewModel as T
        throw IllegalArgumentException("unknown class name")
    }

}