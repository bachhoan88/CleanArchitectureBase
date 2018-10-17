package com.example.clean.di.builder

import com.example.clean.data.di.networkModules
import com.example.clean.data.di.repositoryModules
import com.example.clean.rx.AppSchedulerProvider
import com.example.clean.rx.SchedulerProvider
import org.koin.dsl.module.module

val schedulers = module {
    single { AppSchedulerProvider() as SchedulerProvider }
}

val modules = listOf(viewModels, schedulers, networkModules, repositoryModules)