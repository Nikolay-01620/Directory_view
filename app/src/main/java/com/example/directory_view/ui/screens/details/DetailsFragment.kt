package com.example.directory_view.ui.screens.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.directory_view.DirectoryApplication
import com.example.directory_view.R
import com.example.directory_view.databinding.FragmentDetailsBinding
import com.example.directory_view.ui.Navigator
import com.example.directory_view.utils.DaggerViewModelFactory
import javax.inject.Inject

class DetailsFragment : Fragment(R.layout.fragment_details) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val viewModel: DetailsViewModel by viewModels { viewModelFactory }
    private val binding by viewBinding<FragmentDetailsBinding>()
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var navigator: Navigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as DirectoryApplication)
            .applicationComponent
            .detailsComponent()
            .create()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigator = Navigator(this)

        loadContact(
            args.contactId,
            args.name,
            args.secondName,
            args.phoneNumber,
            args.email
        )

        with(binding) {
            edit.setOnClickListener {
                navigator.detailsToEditScreen()
            }
            contacts.setOnClickListener {
                navigator.popBackStack()
            }
        }
    }

    private fun loadContact(
        contact: Int,
        name: String,
        secondName: String,
        phoneNumber: String,
        email: String
    ) {
        with(binding) {
            this.name.text = name
            this.secondName.text = secondName
            this.phoneNumber.text = phoneNumber
            this.email.text = email
        }
        viewModel.loadContact(contact)
    }

}