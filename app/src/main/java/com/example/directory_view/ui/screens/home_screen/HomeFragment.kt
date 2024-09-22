package com.example.directory_view.ui.screens.home_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.directory_view.DirectoryApplication
import com.example.directory_view.R
import com.example.directory_view.databinding.FragmentHomeBinding
import com.example.directory_view.ui.Navigator
import com.example.directory_view.ui.screens.home_screen.recycler_view.Adapter
import com.example.directory_view.utils.DaggerViewModelFactory
import com.example.directory_view.utils.collectOnLifecycle
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val viewModel: HomeViewModel by viewModels { viewModelFactory }
    private val binding by viewBinding<FragmentHomeBinding>()
    private val adapter: Adapter by lazy { Adapter() }
    private lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as DirectoryApplication)
            .applicationComponent
            .homeComponent()
            .create()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigator = Navigator(this)
        viewModel.loadContacts()

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
            collectOnLifecycle(viewModel.contacts) { contact ->
                adapter.addItem(contact)
            }
            imageButton.setOnClickListener {
                navigator.navigateToAddContact()
            }
        }
    }
}
