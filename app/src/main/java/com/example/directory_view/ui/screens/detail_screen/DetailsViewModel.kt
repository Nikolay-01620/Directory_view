package com.example.directory_view.ui.screens.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val directoryRepository: DirectoryRepository) :
    ViewModel() {

    private val _contacts = MutableStateFlow<DirectoryDomain?>(null)
    val contacts: StateFlow<DirectoryDomain?> = _contacts.asStateFlow()

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _secondName = MutableStateFlow("")
    val secondName: StateFlow<String> = _secondName.asStateFlow()

    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber.asStateFlow()

    private val _photoUri = MutableStateFlow<ByteArray?>(null)
    val photoUri: StateFlow<ByteArray?> = _photoUri.asStateFlow()

    private val _mail = MutableStateFlow("")
    val mail: StateFlow<String> = _mail.asStateFlow()

    fun handleImageSelection(uri: ByteArray) {
        _photoUri.value = uri
    }

    fun loadContact(contactId: Int) {
        viewModelScope.launch {
            val contact = directoryRepository.getContactById(contactId)
            contact?.let {
                _contacts.value = it
                _name.value = it.name
                _secondName.value = it.secondName
                _phoneNumber.value = it.phoneNumber
                _photoUri.value = it.photoUri.toByteArray()
                _mail.value = it.mail
            }
        }
    }
}