package com.example.data.data.di_modules

import android.content.Context
import com.example.data.data.database.DirectoryDao
import com.example.data.data.database.DirectoryDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): DirectoryDatabase {
        return DirectoryDatabase.createDatabase(context)
    }

    @Provides
    fun provideJobSearchDao(database: DirectoryDatabase): DirectoryDao {
        return database.directoryDao()
    }
}