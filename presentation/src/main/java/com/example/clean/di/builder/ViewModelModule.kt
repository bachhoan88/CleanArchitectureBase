package com.example.clean.di.builder

import com.example.clean.domain.usecase.item.SearchItemUseCase
import com.example.clean.model.RepoItemMapper
import com.example.clean.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModels = module {
    viewModel { MainViewModel(SearchItemUseCase(get()), get(), RepoItemMapper()) }
}