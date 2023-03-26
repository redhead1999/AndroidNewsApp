package com.aold.core_db.exceptions

import com.aold.core.core.exceptions.DomainException

/**
 * @author Kirilin Yury on 26.02.2023.
 */

abstract class StorageExceptions : DomainException()

class StorageReadException : StorageExceptions()

class StorageUpdateException : StorageExceptions()

class StorageDeleteException : StorageExceptions()

class StorageWriteException : StorageExceptions()