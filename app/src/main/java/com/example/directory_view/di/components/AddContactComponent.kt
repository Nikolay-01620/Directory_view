package com.example.directory_view.di.components

import com.example.directory_view.ui.screens.add_contact.AddContactFragment
import dagger.Subcomponent

@Subcomponent
interface AddContactComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): AddContactComponent
    }

    fun inject(fragment: AddContactFragment)
}