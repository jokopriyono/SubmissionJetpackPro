package com.jo.submission.jetpackpro.di.component

import android.app.Application
import com.jo.submission.jetpackpro.MvvmApp
import com.jo.submission.jetpackpro.di.builder.ActivityBuilder
import com.jo.submission.jetpackpro.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(mvvmApp: MvvmApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}