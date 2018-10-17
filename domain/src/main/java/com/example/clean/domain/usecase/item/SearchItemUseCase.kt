package com.example.clean.domain.usecase.item

import com.example.clean.domain.model.Item
import com.example.clean.domain.repository.ItemRepository
import com.example.clean.domain.usecase.UseCase
import io.reactivex.Single

open class SearchItemUseCase(
        private val itemRepository: ItemRepository
) : UseCase<SearchItemUseCase.Params, Single<List<Item>>>() {
    override fun createObservable(params: Params?): Single<List<Item>> {
        params?.let { return itemRepository.searchItems(query = params.query, page = params.pageNumber) }

        return Single.error(Throwable(""))
    }

    override fun onCleared() {
    }

    data class Params(val query: String, val pageNumber: Int? = 1)
}

