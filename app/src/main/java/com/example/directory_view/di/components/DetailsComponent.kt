package com.example.directory_view.di.components

import com.example.directory_view.ui.screens.details.DetailsFragment
import dagger.Subcomponent

@Subcomponent
interface DetailsComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailsComponent
    }

    fun inject(fragment: DetailsFragment)
}