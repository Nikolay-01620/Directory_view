package com.example.directory_view.ui.screens.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class EditViewModel @Inject constructor(private val directoryRepository: DirectoryRepository) :
    ViewModel() {

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

    val isButtonEnabled: StateFlow<Boolean> = combine(
        _name,
        _secondName,
        _phoneNumber,
        _photoUri
    ) { name, secondName, phoneNumber, photoUri ->
        name.isNotBlank() || secondName.isNotBlank() || phoneNumber.isNotBlank()
    }.stateIn(viewModelScope, SharingStarted.Lazily, false)

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onSecondNameChange(newSecondName: String) {
        _secondName.value = newSecondName
    }

    fun onPhoneNumberChange(newPhoneNumber: String) {
        _phoneNumber.value = newPhoneNumber
    }

    fun onMailChange(newMail: String) {
        _mail.value = newMail
    }

    fun updateContact(contactId: Int) {
        viewModelScope.launch {
            val updatedContact = DirectoryDomain(
                id = contactId,
                name = _name.value,
                secondName = _secondName.value,
                phoneNumber = _phoneNumber.value,
                photoUri = _photoUri.value.toString(),
                mail = _mail.value
            )
            directoryRepository.updateContact(updatedContact)
        }
    }

    fun deleteContact(contactId: Int) {
        viewModelScope.launch {
            directoryRepository.deleteContact(contactId)
        }
    }

    // загрузка данных для редактирования
    fun loadContact(contactId: Int) {
        viewModelScope.launch {
            val contact = directoryRepository.getContactById(contactId)
            contact?.let {
                _name.value = it.name
                _secondName.value = it.secondName
                _phoneNumber.value = it.phoneNumber
                _photoUri.value = it.photoUri.toByteArray()
                _mail.value = it.mail
            }
        }
    }

    fun handleImageSelection(uri: ByteArray) {
        _photoUri.value = uri
    }

    fun fakeClearFields() {

    }
}