package com.example.clean.domain.model

data class Item(
        val id: Int,
        val name: String,
        val description: String,
        val url: String
) : Model()
