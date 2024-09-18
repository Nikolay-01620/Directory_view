package com.example.directory_view.ui.screens.main_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val directoryRepository: DirectoryRepository) : ViewModel() {

    private val _contacts = MutableStateFlow<List<DirectoryDomain>>(emptyList())
    val contacts: StateFlow<List<DirectoryDomain>> = _contacts.asStateFlow()

    private var allContacts = emptyList<DirectoryDomain>()

    init {
        loadContacts()
    }

    fun loadContacts() {
        viewModelScope.launch {
            val contacts = directoryRepository.getAllContacts()
            allContacts = contacts
            _contacts.value = contacts
            Log.d("MainScreen", contacts.toString())
        }
    }

    fun searchContacts(
        query: String
    ) {
        if (query.isEmpty()) {
            _contacts.value = allContacts


        } else {
            val searchTerms =
                query.split(" ")
                    .filter { it.isNotEmpty() }
            _contacts.value = allContacts.filter { contact ->
                searchTerms.all { term ->
                    contact.name.contains(term, ignoreCase = true) ||
                            contact.secondName.contains(term, ignoreCase = true) ||
                            contact.phoneNumber.contains(term)
                }
            }
        }
    }
}
