package com.example.data.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.data.model.DirectoryData

@Database(entities = [DirectoryData::class], version = 1)
abstract class DirectoryDatabase : RoomDatabase() {
    abstract fun directoryDao(): DirectoryDao

    companion object {
        private var database: DirectoryDatabase? = null

        fun createDatabase(context: Context): DirectoryDatabase {
            if (database == null) {
                synchronized(DirectoryDatabase::class.java) {
                    if (database == null) {
                        database = Room.databaseBuilder(
                            context.applicationContext,
                            DirectoryDatabase::class.java, "directory_database4"
                        ).build()
                    }
                }
            }
            return database!!
        }
    }
}
