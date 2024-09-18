package com.example.directory_view.ui.screens.detail_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.directory_view.DirectoryApplication

class DetailsFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as DirectoryApplication)
            .applicationComponent
            .detailsComponent()
            .create()
            .inject(this)
    }
}