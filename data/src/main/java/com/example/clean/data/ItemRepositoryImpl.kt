package com.example.clean.data

import com.example.clean.data.model.ItemEntityMapper
import com.example.clean.data.remote.api.ItemApi
import com.example.clean.domain.model.Item
import com.example.clean.domain.repository.ItemRepository
import io.reactivex.Single

class ItemRepositoryImpl(
        private val itemApi: ItemApi,
        private val itemEntityMapper: ItemEntityMapper
) : ItemRepository {
    override fun searchItems(query: String, page: Int?): Single<List<Item>> {
        return itemApi.searchRepos(query = query, page = if (page == null) 0 else page)
                .map { response ->
                    response.items.map { itemEntityMapper.mapToDomain(it) }
                }
                .doOnError { Throwable("Not found!") }
    }

}