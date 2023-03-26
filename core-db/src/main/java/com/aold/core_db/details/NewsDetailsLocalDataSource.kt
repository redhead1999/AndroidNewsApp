package com.aold.core_db.details

import com.aold.core_db.exceptions.StorageReadException

/**
 * @author Kirilin Yury on 01.03.2023.
 */
interface NewsDetailsLocalDataSource {

    suspend fun read(): NewsDetailsModel

    suspend fun save(news: NewsDetailsModel)

    class Base : NewsDetailsLocalDataSource {

        private var localStorage: NewsDetailsModel? = null

        override suspend fun read(): NewsDetailsModel {
            return localStorage ?: throw StorageReadException()
        }

        override suspend fun save(news: NewsDetailsModel) {
            localStorage = news
        }

    }
}