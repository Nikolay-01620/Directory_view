package com.example.directory_view.ui.screens.home_screen.recycler_view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    private var photoId: List<Int> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photoId[position])
    }

    override fun getItemCount(): Int {
        return photoId.size
    }

    fun addPhoto(photos: List<Int>) {
        photoId = photos
        val positionInserted = photoId.size - 1
        notifyItemInserted(positionInserted)
    }

}