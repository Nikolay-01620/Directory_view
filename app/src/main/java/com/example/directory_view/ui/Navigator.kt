package com.example.directory_view.ui

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.directory_view.R
import com.example.directory_view.ui.screens.home.HomeFragmentDirections
import com.example.domain.model.DirectoryDomain

class Navigator(private val fragment: Fragment) {

    fun homeToAddContactScreen() {
        fragment.findNavController().navigate(R.id.action_homeFragment_to_addContactFragment)
    }

    fun homeToDetailsScreen(contact: DirectoryDomain) {
        val direction =
            HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                contact.id,
                contact.name,
                contact.secondName,
                contact.phoneNumber,
                contact.mail
            )
        fragment.findNavController().navigate(direction)
    }

    fun detailsToEditScreen() {
        fragment.findNavController().navigate(R.id.action_detailsFragment_to_editFragment)
    }

    fun popBackStack() {
        fragment.findNavController().navigateUp()
    }

    fun homeToEditScreen(contact: DirectoryDomain) {
        val direction = HomeFragmentDirections.actionHomeFragmentToEditFragment(contact.id)
        fragment.findNavController().navigate(direction)
    }
}
