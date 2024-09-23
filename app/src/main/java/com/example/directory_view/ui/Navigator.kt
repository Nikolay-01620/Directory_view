package com.example.directory_view.ui

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.directory_view.R
import com.example.domain.model.DirectoryDomain

class Navigator(private val fragment: Fragment) {

    fun homeToAddContactScreen() {
        fragment.findNavController().navigate(R.id.action_homeFragment_to_addContactFragment)
    }

    fun homeToDetailsScreen() {
        fragment.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
    }

    fun detailsToEditScreen() {
        fragment.findNavController().navigate(R.id.action_detailsFragment_to_editFragment)
    }

    fun homeToEditScreen(contact:DirectoryDomain) {
        fragment.findNavController().navigate(R.id.action_homeFragment_to_editFragment)
    }

    fun popBackStack() {
        fragment.findNavController().navigateUp()
    }
}
