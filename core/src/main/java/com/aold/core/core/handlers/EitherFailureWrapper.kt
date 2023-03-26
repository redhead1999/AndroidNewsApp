package com.aold.core.core.handlers

import com.aold.core.core.functional.Either

/**
 * @author Kirilin Yury on 26.02.2023.
 */

interface EitherFailureWrapper<L> {

    suspend fun <R> wrap(block: suspend () -> R): Either<L, R>

    abstract class Abstract<L>(
        private val errorHandler: ErrorHandler<L>
    ) : EitherFailureWrapper<L> {

        override suspend fun <R> wrap(block: suspend () -> R) = try {
            Either.Right(block.invoke())
        } catch (e: Throwable) {
            Either.Left(errorHandler.handle(e))
        }
    }
}
