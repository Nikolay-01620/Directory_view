package com.example.directory_view.ui.screens.edit_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.directory_view.DirectoryApplication

class EditFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as DirectoryApplication)
            .applicationComponent
            .editComponent()
            .create()
            .inject(this)
    }
}