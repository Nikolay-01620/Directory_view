package com.example.data.utils

import com.example.data.data.model.DirectoryData
import com.example.domain.model.DirectoryDomain

fun DirectoryDomain.toData() = DirectoryData(
    id = id,
    name = name,
    secondName = secondName,
    phoneNumber = phoneNumber,
    photoUri = photoUri,
    mail = mail
)

fun DirectoryData.toDomain() = DirectoryDomain(
    id = id,
    name = name,
    secondName = secondName,
    phoneNumber = phoneNumber,
    photoUri = photoUri,
    mail = mail
)