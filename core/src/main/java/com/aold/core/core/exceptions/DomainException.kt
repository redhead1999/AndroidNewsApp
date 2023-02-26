package com.aold.core.core.exceptions

import retrofit2.HttpException

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

abstract class DomainException:IllegalStateException()

class NetworkException : DomainException()

class ServiceUnavailableException(val httpException: HttpException) : DomainException()

class DataBaseException(val throwable: Throwable) : DomainException()