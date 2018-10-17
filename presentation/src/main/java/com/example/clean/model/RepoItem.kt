package com.example.clean.model

import com.example.clean.base.ItemMapper
import com.example.clean.base.ModelItem
import com.example.clean.domain.model.Item

data class RepoItem(
        val id: Int,
        val name: String,
        val description: String,
        val url: String
) : ModelItem()

class RepoItemMapper : ItemMapper<Item, RepoItem> {
    override fun mapToPresentation(model: Item) = RepoItem(
            id = model.id,
            name = model.name,
            description = model.description,
            url = model.url
    )

    override fun mapToDomain(modelItem: RepoItem) = Item(
            id = modelItem.id,
            name = modelItem.name,
            description = modelItem.description,
            url = modelItem.url
    )
}