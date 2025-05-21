package com.example.directory_view.ui.screens.home.recycler_view

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.DirectoryDomain

class DirectoryDiffCallback : DiffUtil.ItemCallback<DirectoryDomain>() {
    override fun areItemsTheSame(oldItem: DirectoryDomain, newItem: DirectoryDomain): Boolean {
        return (oldItem.id == newItem.id)
    }

    override fun areContentsTheSame(oldItem: DirectoryDomain, newItem: DirectoryDomain): Boolean {
        return (oldItem == newItem)
    }

    override fun getChangePayload(oldItem: DirectoryDomain, newItem: DirectoryDomain): Any? {
        return when {
            oldItem.name != newItem.name -> newItem.name
            oldItem.secondName != newItem.secondName -> newItem.secondName
            oldItem.phoneNumber != newItem.phoneNumber -> newItem.phoneNumber
            oldItem.photoUri != newItem.photoUri -> newItem.photoUri
            oldItem.mail != newItem.mail -> newItem.mail
            else -> null
        }
    }
}