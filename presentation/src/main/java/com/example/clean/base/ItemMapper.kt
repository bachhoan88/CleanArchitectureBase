package com.example.clean.base

import com.example.clean.domain.model.Model

interface ItemMapper<M : Model, MI : ModelItem> {
    fun mapToPresentation(model: M): ModelItem

    fun mapToDomain(modelItem: MI): Model
}