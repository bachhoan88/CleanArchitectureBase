package com.example.clean.data.remote.api

import com.example.clean.data.remote.response.SearchRepoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemApi {

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String, @Query("page") page: Int): Single<SearchRepoResponse>
}