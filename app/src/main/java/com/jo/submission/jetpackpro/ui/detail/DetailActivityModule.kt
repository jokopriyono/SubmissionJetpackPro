package com.jo.submission.jetpackpro.ui.detail

import androidx.lifecycle.ViewModelProvider
import com.jo.submission.jetpackpro.ViewModelProviderFactory
import com.jo.submission.jetpackpro.data.DataManager
import com.jo.submission.jetpackpro.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule {

    @Provides
    fun detailViewModelProvider(detailViewModel: DetailViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(detailViewModel)

    @Provides
    fun provideDetailViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): DetailViewModel =
        DetailViewModel(dataManager, schedulerProvider)
}