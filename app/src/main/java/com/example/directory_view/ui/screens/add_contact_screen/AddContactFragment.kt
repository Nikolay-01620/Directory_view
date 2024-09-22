package com.example.directory_view.ui.screens.add_contact_screen

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.directory_view.DirectoryApplication
import com.example.directory_view.R
import com.example.directory_view.databinding.FragmentAddContactBinding
import com.example.directory_view.ui.Navigator
import com.example.directory_view.utils.DaggerViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddContactFragment : Fragment(R.layout.fragment_add_contact) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val viewModel: AddContactViewModel by viewModels { viewModelFactory }
    private val binding by viewBinding<FragmentAddContactBinding>()
    private lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as DirectoryApplication)
            .applicationComponent
            .addContactComponent()
            .create()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigator = Navigator(this)

        with(binding) {
            cancelButton.setOnClickListener {
                navigator.popBackStack()
            }
            setupInputListeners()
            doneButton.setOnClickListener {
                addContact()
                navigator.popBackStack()
            }
        }
    }

    private fun addContact() {
        with(binding) {
            with(viewModel) {
                onNameChange(nameInput.text.toString())
                onSecondNameChange(secondNameInput.text.toString())
                onMailChange(emailInput.text.toString())
                onPhoneNumberChange(phoneInput.text.toString())
                addContact()
            }
        }
    }

    private fun setupInputListeners() {
        with(binding) {
            val inputs = listOf(nameInput, secondNameInput, emailInput, phoneInput)
            inputs.forEach { input ->
                input.doAfterTextChanged {
                    val isAnyFieldFilled = inputs.any { it.text.isNotBlank() }
                    doneButton.isEnabled = isAnyFieldFilled
                }
            }
        }
    }
    private fun setupInputListeners1() {
        with(binding) {
            val inputs = listOf(nameInput, secondNameInput, emailInput, phoneInput)
            inputs.forEach { input ->
                input.doAfterTextChanged {
                    val isAnyFieldFilled = inputs.any { it.text.isNotBlank() }

                    viewLifecycleOwner.lifecycleScope.launch {
                        viewModel.isButtonEnabled.collect {
                            doneButton.isEnabled = isAnyFieldFilled
                        }
                    }
                }
            }
        }
    }
}