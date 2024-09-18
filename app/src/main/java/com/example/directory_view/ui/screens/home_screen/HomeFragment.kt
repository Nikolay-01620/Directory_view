package com.example.directory_view.ui.screens.home_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.directory_view.DirectoryApplication
import com.example.directory_view.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as DirectoryApplication)
            .applicationComponent
            .homeComponent()
            .create()
            .inject(this)
    }
}