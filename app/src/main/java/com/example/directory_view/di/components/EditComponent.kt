package com.example.directory_view.di.components

import com.example.directory_view.ui.screens.edit.EditFragment
import dagger.Subcomponent

@Subcomponent
interface EditComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): EditComponent
    }

    fun inject(fragment: EditFragment)
}