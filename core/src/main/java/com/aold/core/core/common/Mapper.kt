package com.aold.core.core.common

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */
interface Mapper<I, O> {
    fun map(input: I): O
}