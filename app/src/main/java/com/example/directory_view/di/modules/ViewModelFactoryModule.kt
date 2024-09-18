package com.example.directory_view.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.directory_view.utils.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

}