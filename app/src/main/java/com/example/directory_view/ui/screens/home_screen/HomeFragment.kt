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
import com.example.directory_view.ui.screens.home_screen.recycler_view.Adapter
import com.example.directory_view.ui.screens.home_screen.recycler_view.Contact
import com.example.directory_view.ui.screens.home_screen.recycler_view.contactItems
import com.example.directory_view.utils.DaggerViewModelFactory
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val viewModel: HomeViewModel by viewModels { viewModelFactory }
    private val binding by viewBinding<FragmentHomeBinding>()
    private val adapter: Adapter by lazy { Adapter() }

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
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(this@HomeFragment.context)
            recyclerView.adapter = adapter
            adapter.addItem(contactItems)
        }
    }
}