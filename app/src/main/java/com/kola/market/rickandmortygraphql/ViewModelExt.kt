package com.kola.market.rickandmortygraphql

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import timber.log.Timber


fun <T> BaseViewModel.emitFlowResults(
    liveDataObject: MutableLiveData<RichAndMortyResult<T>>,
    networkRequest: () -> Flow<RichAndMortyResult<T>>
) {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        // 1. Trigger event to prompt error dialog
        // 2. Log to tracking system for observability
        Timber.tag("coroutineExceptionHandler").e("coroutineExceptionHandler --> $throwable")
    }
    val coroutineScope = (viewModelScope + exceptionHandler)

    coroutineScope.launch(Dispatchers.IO) {
        networkRequest()
            .onStart { liveDataObject.postValue(RichAndMortyResult.Loading) }
            .onEach {
                liveDataObject.postValue(it)
            }
            .catch {
//                liveDataObject.postValue(RichAndMortyResult.Error( DataSourceException.messageResource()))
            }
            .launchIn(this)

    }
}
