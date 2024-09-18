package com.example.directory_view.di.components

import android.content.Context
import com.example.data.data.di_modules.DatabaseModule
import com.example.data.data.di_modules.RepositoryModule
import com.example.directory_view.MainActivity
import com.example.directory_view.di.modules.ViewModelFactoryModule
import com.example.directory_view.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        ViewModelFactoryModule::class,
        RepositoryModule::class,
        DatabaseModule::class]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }

    fun addContactComponent(): AddContactComponent.Factory
    fun detailsComponent(): DetailsComponent.Factory
    fun editComponent(): EditComponent.Factory
    fun homeComponent(): HomeComponent.Factory

}