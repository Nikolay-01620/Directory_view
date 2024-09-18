package com.example.directory_view.di.components

import com.example.directory_view.ui.screens.main_screen.HomeFragment
import dagger.Subcomponent

@Subcomponent
interface HomeComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(fragment: HomeFragment)
}