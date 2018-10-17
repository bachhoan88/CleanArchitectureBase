package com.example.clean.data.model

import com.example.clean.data.base.EntityMapper
import com.example.clean.data.base.ModelEntity
import com.example.clean.domain.model.Item
import com.google.gson.annotations.SerializedName

data class ItemEntity(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("full_name") val description: String,
        @SerializedName("url") val url: String
) : ModelEntity()

class ItemEntityMapper : EntityMapper<Item, ItemEntity> {
    override fun mapToDomain(entity: ItemEntity) = Item(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            url = entity.url
    )

    override fun mapToEntity(model: Item) = ItemEntity(
            id = model.id,
            name = model.name,
            description = model.description,
            url = model.url
    )

}