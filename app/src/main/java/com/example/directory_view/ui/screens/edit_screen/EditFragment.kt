package com.example.directory_view.ui.screens.edit_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.directory_view.DirectoryApplication
import com.example.directory_view.R
import com.example.directory_view.databinding.FragmentAddContactBinding
import com.example.directory_view.databinding.FragmentEditBinding
import com.example.directory_view.ui.Navigator
import com.example.directory_view.ui.screens.add_contact_screen.AddContactViewModel
import com.example.directory_view.utils.DaggerViewModelFactory
import javax.inject.Inject
import kotlin.properties.Delegates

class EditFragment :
    Fragment(R.layout.fragment_edit) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val viewModel: EditViewModel by viewModels { viewModelFactory }
    private val binding by viewBinding<FragmentEditBinding>()
    private lateinit var navigator: Navigator
    private var contactId: Int = 0
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

        with(binding) {
            cancelButton.setOnClickListener {
                navigator.popBackStack()
            }
            deleteButton.setOnClickListener {
                deleteContact(contactId)
                navigator.popBackStack()
            }
        }


    }

    private fun deleteContact(contactId: Int) {
        viewModel.deleteContact(contactId)
    }

}