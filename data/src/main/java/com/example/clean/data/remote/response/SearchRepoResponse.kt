package com.example.clean.data.remote.response

import com.example.clean.data.model.ItemEntity
import com.google.gson.annotations.SerializedName

data class SearchRepoResponse(
        @SerializedName("total_count") val total: Int = 0,
        @SerializedName("items") val items: List<ItemEntity>
)
