package com.example.directory_view.ui.screens.home_screen.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.directory_view.R
import com.example.directory_view.databinding.ItemContactBinding
import com.example.domain.model.DirectoryDomain

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding by lazy { ItemContactBinding.bind(itemView) }

    companion object {
        fun from(parent: ViewGroup) = ViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_contact, parent, false)
        )
    }

    fun bind(contact: DirectoryDomain) {
        with(binding) {
            imageView.setImageResource(R.drawable.ic_launcher_foreground)
            contactName.text = contact.name
            contactPhone.text = contact.phoneNumber
        }
    }
}