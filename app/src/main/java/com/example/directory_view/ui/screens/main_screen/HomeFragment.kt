package com.example.directory_view.ui.screens.main_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.directory_view.DirectoryApplication

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as DirectoryApplication)
            .applicationComponent
            .homeComponent()
            .create()
            .inject(this)
    }
}