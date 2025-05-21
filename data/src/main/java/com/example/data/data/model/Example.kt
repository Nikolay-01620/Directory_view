package com.example.data.data.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(foreignKeys = [ForeignKey(
    entity = DirectoryData::class,
    parentColumns = ["user","",""],
    childColumns = [""],
    onUpdate = ForeignKey.CASCADE
)])
data class Example(
    val example : Int
)
