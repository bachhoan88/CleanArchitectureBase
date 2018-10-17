package com.example.clean.domain.repository

import com.example.clean.domain.model.Item
import io.reactivex.Single

interface ItemRepository : Repository {
    fun searchItems(query: String, page: Int? = 1): Single<List<Item>>
}