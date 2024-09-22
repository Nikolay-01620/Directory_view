package com.example.directory_view.ui

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.directory_view.R

class Navigator(private val fragment: Fragment) {

    fun navigateToAddContact() {
        fragment.findNavController().navigate(R.id.action_homeFragment_to_addContactFragment)
    }

    fun popBackStack() {
        fragment.findNavController().navigateUp()
    }
}
