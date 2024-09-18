package com.example.directory_view

import android.app.Application
import com.example.directory_view.di.components.ApplicationComponent
import com.example.directory_view.di.components.DaggerApplicationComponent


class DirectoryApplication : Application() {

    companion object {
        lateinit var instance: DirectoryApplication
    }


    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        instance = this
        if (!this::applicationComponent.isInitialized)
            applicationComponent = DaggerApplicationComponent.factory().create(applicationContext)

    }
}
