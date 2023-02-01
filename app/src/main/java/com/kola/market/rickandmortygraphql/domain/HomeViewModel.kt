package com.kola.market.rickandmortygraphql.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.datasource.models.CharacterDetailsModel
import com.kola.market.rickandmortygraphql.datasource.models.CharactersModel
import com.kola.market.rickandmortygraphql.di.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _resultListCharacters = MutableLiveData<RichAndMortyResult<CharactersModel?>>()
    val resultListCharacters: LiveData<RichAndMortyResult<CharactersModel?>> = _resultListCharacters

    private val _resultCharacterDetails = MutableLiveData<RichAndMortyResult<CharacterDetailsModel?>>()
    val resultCharacterDetails: LiveData<RichAndMortyResult<CharacterDetailsModel?>> = _resultCharacterDetails

     fun getCharacters(page: Int) {
         viewModelScope.launch {
                 useCases.characterUseCases(page).collect {
                     _resultListCharacters.postValue(it)
                 }
         }
    }

    fun getCharacterDetails(id: String){
        viewModelScope.launch {
            useCases.characterDetailsUseCases(id).collect{
                _resultCharacterDetails.postValue(it)
            }
        }
    }
}
