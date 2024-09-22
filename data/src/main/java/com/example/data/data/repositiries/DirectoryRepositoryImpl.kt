package com.example.data.data.repositiries

import com.example.data.data.database.DirectoryDao
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import com.example.data.utils.toData
import com.example.data.utils.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DirectoryRepositoryImpl @Inject constructor(private val directoryDao: DirectoryDao) :
    DirectoryRepository {
    override suspend fun insertContact(directoryDomain: DirectoryDomain) {
        withContext(Dispatchers.IO) {
            directoryDao.insert(directoryDomain.toData())
        }
    }

    override suspend fun deleteContact(contactId: Int) {
        directoryDao.delete(contactId)
    }

    override suspend fun updateContact(directoryDomain: DirectoryDomain) {
        withContext(Dispatchers.IO) {
            directoryDao.update(directoryDomain.toData())
        }
    }

    override suspend fun getAllContacts(): List<DirectoryDomain> {
        return withContext(Dispatchers.IO) {
            directoryDao.getAllContacts().map { it.toDomain() }
        }
    }

    override suspend fun getContactById(contactId: Int): DirectoryDomain? {
        return withContext(Dispatchers.IO) {
            directoryDao.getContactById(contactId)?.toDomain()
        }
    }
}
