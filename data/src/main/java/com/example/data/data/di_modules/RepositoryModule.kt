package com.example.data.data.di_modules

import com.example.data.data.repositiries.DirectoryRepositoryImpl
import com.example.domain.repositories.DirectoryRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {
    @Provides
    fun provideRepository(directoryRepositoryImpl: DirectoryRepositoryImpl): DirectoryRepository {
        return directoryRepositoryImpl
    }
}