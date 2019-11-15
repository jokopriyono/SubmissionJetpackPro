package com.jo.submission.jetpackpro.di.module

import android.app.Application
import android.content.Context
import com.jo.submission.jetpackpro.data.AppDataManager
import com.jo.submission.jetpackpro.data.DataManager
import com.jo.submission.jetpackpro.data.remote.ApiHelper
import com.jo.submission.jetpackpro.data.remote.AppApiHelper
import com.jo.submission.jetpackpro.di.PreferenceInfo
import com.jo.submission.jetpackpro.utils.AppConstants
import com.jo.submission.jetpackpro.utils.rx.AppSchedulerProvider
import com.jo.submission.jetpackpro.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    @PreferenceInfo
    fun providePreferenceName() = AppConstants.PREF_NAME

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}