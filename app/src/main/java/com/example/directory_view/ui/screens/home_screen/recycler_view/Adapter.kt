package com.example.directory_view.ui.screens.home_screen.recycler_view

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    private val contactList = ArrayList<Contact>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addItem(contact: List<Contact>) {
        contactList.addAll(contact)
        notifyDataSetChanged()
    }

}