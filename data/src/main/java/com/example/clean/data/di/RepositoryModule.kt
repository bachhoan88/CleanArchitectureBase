package com.example.clean.data.di

import android.content.Context
import com.example.clean.data.ItemRepositoryImpl
import com.example.clean.data.local.pref.AppPrefs
import com.example.clean.data.local.pref.PrefHelper
import com.example.clean.data.model.ItemEntityMapper
import com.example.clean.data.remote.api.ItemApi
import com.example.clean.domain.repository.ItemRepository
import org.koin.dsl.module.module
import org.koin.java.standalone.KoinJavaComponent.get

fun createPrefHelper(appPrefs: AppPrefs): PrefHelper = appPrefs

fun createAppPrefs(context: Context): AppPrefs = AppPrefs(context)

fun createItemRepositoryImpl(itemApi: ItemApi): ItemRepositoryImpl = ItemRepositoryImpl(itemApi, ItemEntityMapper())

fun createItemRepository(itemRepositoryImpl: ItemRepositoryImpl): ItemRepository = itemRepositoryImpl

val repositoryModules = module {
//    single { createAppPrefs(get()) }
//
    single { createItemRepositoryImpl(get()) }
//
    single { createItemRepository(get()) }
//
//    single { createPrefHelper(get()) }
}
