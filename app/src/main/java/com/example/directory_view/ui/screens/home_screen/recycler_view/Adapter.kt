package com.example.directory_view.ui.screens.home_screen.recycler_view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.DirectoryDomain

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    private var contactList: List<DirectoryDomain> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    fun addItem(photos: List<DirectoryDomain>) {
        contactList = photos
        val positionInserted = contactList.size - 1
        notifyItemInserted(positionInserted)
    }
}