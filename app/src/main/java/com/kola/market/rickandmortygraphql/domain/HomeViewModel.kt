package com.kola.market.rickandmortygraphql.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kola.market.rickandmortygraphql.BaseViewModel
import com.kola.market.rickandmortygraphql.GetCharactersQuery
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.datasource.models.CharactersModel
import com.kola.market.rickandmortygraphql.usecases.CharacterUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterUseCases: CharacterUseCases
): ViewModel() {

    private val _resultListCharacters = MutableLiveData<RichAndMortyResult<CharactersModel?>>()
    val resultListCharacters: LiveData<RichAndMortyResult<CharactersModel?>> = _resultListCharacters


     fun getCharacters(){
         viewModelScope.launch {
                 characterUseCases(2).collect {
                     Log.d("ViewModelData->>>", it.toString())
                     _resultListCharacters.postValue(it)
                 }
         }
    }
}
