package com.example.directory_view.ui.screens.add_contact_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.directory_view.DirectoryApplication

class AddContactFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as DirectoryApplication)
            .applicationComponent
            .addContactComponent()
            .create()
            .inject(this)
    }
}