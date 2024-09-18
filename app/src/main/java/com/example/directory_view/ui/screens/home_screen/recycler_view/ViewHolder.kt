package com.example.directory_view.ui.screens.home_screen.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.directory_view.R
import com.example.directory_view.databinding.ItemContactBinding

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun from(parent: ViewGroup) = ViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_contact, parent, false)
        )
    }

    private val binding by lazy { ItemContactBinding.bind(itemView) }

    fun bind(photoId: Int) {
        Glide.with(itemView)
            .load(photoId)
            .centerCrop()
            .into(binding.imageView)
    }
}