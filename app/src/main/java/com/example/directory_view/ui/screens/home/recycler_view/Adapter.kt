package com.example.directory_view.ui.screens.home.recycler_view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.DirectoryDomain

class Adapter(private val listener: OnClickListener) : RecyclerView.Adapter<ViewHolder>() {
    private var contactList: List<DirectoryDomain> = listOf()

    interface OnClickListener {
        fun onClick(contact: DirectoryDomain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactList[position],listener)
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