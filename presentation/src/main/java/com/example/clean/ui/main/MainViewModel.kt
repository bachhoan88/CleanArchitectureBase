package com.example.clean.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.clean.base.BaseViewModel
import com.example.clean.domain.usecase.item.SearchItemUseCase
import com.example.clean.model.RepoItem
import com.example.clean.model.RepoItemMapper
import com.example.clean.rx.SchedulerProvider

class MainViewModel (
        private val searchItemUseCase: SearchItemUseCase,
        private val schedulerProvider: SchedulerProvider,
        private val repoItemMapper: RepoItemMapper
) : BaseViewModel(searchItemUseCase) {

    val data = MutableLiveData<List<RepoItem>>()
    val query = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>().apply { postValue(false) }

    fun searchRepo() {
        query.value?.let { input ->
            if (input.isNotBlank()) {
                loading.value = true

                compositeDisposable.add(searchItemUseCase.createObservable(SearchItemUseCase.Params(query = input, pageNumber = 1))
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .doFinally { loading.value = false }
                        .map { items ->
                            items.map { item ->
                                repoItemMapper.mapToPresentation(item)
                            }
                        }
                        .subscribe({ items ->
                            data.value = items
                        }, {})
                )
            }
        }
    }

}
