package com.example.directory_view.di.modules

import androidx.lifecycle.ViewModel
import com.example.directory_view.ui.screens.add_contact_screen.AddContactViewModel
import com.example.directory_view.ui.screens.detail_screen.DetailsViewModel
import com.example.directory_view.ui.screens.edit_screen.EditViewModel
import com.example.directory_view.ui.screens.home_screen.HomeViewModel
import com.example.directory_view.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @ViewModelKey(AddContactViewModel::class)
    @IntoMap
    @Binds
    abstract fun bindAddContactViewModel(addContactViewModel: AddContactViewModel): ViewModel

    @ViewModelKey(DetailsViewModel::class)
    @IntoMap
    @Binds
    abstract fun bindDetailsViewModel(detailsViewModel: DetailsViewModel): ViewModel

    @ViewModelKey(EditViewModel::class)
    @IntoMap
    @Binds
    abstract fun bindEditViewModel(editViewModel: EditViewModel): ViewModel

    @ViewModelKey(HomeViewModel::class)
    @IntoMap
    @Binds
    abstract fun bindMainViewModel(homeViewModel: HomeViewModel): ViewModel

}