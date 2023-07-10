package com.lidorttol.rickandmorty.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.utils.AsyncResult
import com.lidorttol.rickandmorty.data.utils.Event
import com.lidorttol.rickandmorty.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
) : ViewModel() {

    private val charactersLiveData = MutableLiveData<Event<AsyncResult<List<CharacterBo>?>>>()

    fun getCharacters(): LiveData<Event<AsyncResult<List<CharacterBo>?>>> = charactersLiveData

    fun requestCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            getCharactersUseCase().collect {
                charactersLiveData.postValue(it)
            }
        }
    }

}