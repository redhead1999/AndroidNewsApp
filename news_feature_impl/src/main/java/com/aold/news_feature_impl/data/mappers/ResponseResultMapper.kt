package com.aold.news_feature_impl.data.mappers

import androidx.paging.PagingSource.LoadParams
import androidx.paging.PagingSource.LoadResult
import com.aold.core.core.functional.ResponseResult
import com.aold.news_feature_impl.data.data_sources.network.paging.PagingParamsHandler
import javax.inject.Inject

/**
 * @author Kirilin Yury on 13.03.2023.
 */
internal interface ResponseResultMapper<T : Any> {

    fun mapToLoadResult(
        responseResult: ResponseResult<List<T>>,
        pagingParams: LoadParams<Int>,
        initialPage: Int = 1
    ): LoadResult<Int, T>

    class Base<T : Any> @Inject constructor(
        private val paramsHandler: PagingParamsHandler
    ) : ResponseResultMapper<T> {

        override fun mapToLoadResult(
            responseResult: ResponseResult<List<T>>,
            pagingParams: LoadParams<Int>,
            initialPage: Int
        ): LoadResult<Int, T> = when (responseResult) {
            is ResponseResult.Success.Data -> {
                val pageInfo =
                    paramsHandler.handlePage(pagingParams, responseResult.data.size, initialPage)
                LoadResult.Page(responseResult.data, pageInfo.prev, pageInfo.next)
            }
            is ResponseResult.Success.Empty -> {
                val pageInfo = paramsHandler.handlePage(pagingParams, 0, initialPage)
                LoadResult.Page(emptyList(), pageInfo.prev, pageInfo.next)
            }
            is ResponseResult.Error -> {
                LoadResult.Error(responseResult.throwable)
            }
        }
    }
}