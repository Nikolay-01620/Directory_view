package com.example.directory_view.ui.screens.edit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.directory_view.DirectoryApplication
import com.example.directory_view.R
import com.example.directory_view.databinding.FragmentEditBinding
import com.example.directory_view.ui.Navigator
import com.example.directory_view.utils.DaggerViewModelFactory
import javax.inject.Inject

class EditFragment : Fragment(R.layout.fragment_edit) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val viewModel: EditViewModel by viewModels { viewModelFactory }
    private val binding by viewBinding<FragmentEditBinding>()
    private lateinit var navigator: Navigator
    private val args: EditFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as DirectoryApplication)
            .applicationComponent
            .editComponent()
            .create()
            .inject(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigator = Navigator(this)

        loadContact()
        with(binding) {
            cancelButton.setOnClickListener {
                navigator.popBackStack()
            }
            deleteButton.setOnClickListener {
                deleteContact(args.contactId)
            }
            doneButton.setOnClickListener {
                updateContact(args.contactId)
                navigator.popBackStack()
            }
        }
    }

    private fun updateContact(contactId: Int) {
        with(binding) {
            with(viewModel) {
                onNameChange(nameInput.text.toString())
                onSecondNameChange(secondNameInput.text.toString())
                onMailChange(emailInput.text.toString())
                onPhoneNumberChange(phoneNumberInput.text.toString())
                updateContact(contactId)
            }
        }
    }

    //загрузка данных в поля
    private fun loadContact() {
        with(binding) {
            nameInput.setText(args.name)
            secondNameInput.setText(args.secondName)
            phoneNumberInput.setText(args.phoneNumber)
            emailInput.setText(args.email)
        }
    }

    private fun deleteContact(contactId: Int) {
        viewModel.deleteContact(contactId)
        navigator.editToHomeScreen()
    }
}