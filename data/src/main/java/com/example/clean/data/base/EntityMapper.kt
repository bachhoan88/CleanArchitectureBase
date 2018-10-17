package com.example.clean.data.base

import com.example.clean.domain.model.Model


interface EntityMapper<M : Model, ME : ModelEntity> {
    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME
}