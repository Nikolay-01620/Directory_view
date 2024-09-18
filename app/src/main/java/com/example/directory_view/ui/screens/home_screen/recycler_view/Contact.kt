package com.example.directory_view.ui.screens.home_screen.recycler_view

import com.example.directory_view.R

data class Contact(
    val imageId: Int,
    val name: String,
    val number: String
)

 val contactItems = listOf(
    Contact(R.drawable.ic_launcher_foreground, "John Doe", "+1 234 567 890"),
    Contact(R.drawable.ic_launcher_foreground, "Jane Smith", "+1 987 654 321"),
    Contact(R.drawable.ic_launcher_foreground, "Mike Johnson", "+1 555 123 456"),
    Contact(R.drawable.ic_launcher_foreground, "Emily White", "+1 999 888 777"),
    Contact(R.drawable.ic_launcher_foreground, "Sara Lee", "+1 123 456 789")
)
