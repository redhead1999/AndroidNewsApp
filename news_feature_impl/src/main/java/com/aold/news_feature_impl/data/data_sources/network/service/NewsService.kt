package com.aold.news_feature_impl.data.data_sources.network.service

import com.aold.news_feature_impl.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Kirilin Yury on 13.03.2023.
 */
internal interface NewsService {

    /**
     * @param category the articles topic.
     * @param language the language of returned articles.
     * @param country the country of returned articles.
     * @param page use this parameter to paginate results.
     * @param max the maximum number of articles returned per request.
     *
     * @return List of [NewsResponse]
     */

    @GET("/api/v4/top-headlines")
    suspend fun fetchNews(
        @Query("topic") category: String,
        @Query("lang") language: String,
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("max") max: Int = 10
    ): Response<NewsResponse>
}