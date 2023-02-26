package com.aold.core.core.handlers

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

interface ErrorHandler<T> {
    fun handle(throwable: Throwable): T
}