package com.lidorttol.rickandmorty.ui.characterdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.utils.AsyncResult
import com.lidorttol.rickandmorty.data.utils.Event
import com.lidorttol.rickandmorty.domain.GetCharacterByIdUseCase
import com.lidorttol.rickandmorty.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val characterLiveData = MutableLiveData<Event<AsyncResult<CharacterBo?>>>()

    fun getCharacter(): LiveData<Event<AsyncResult<CharacterBo?>>> = characterLiveData

    fun requestCharacterById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            getCharacterByIdUseCase(id).collect {
                characterLiveData.postValue(it)
            }
        }
    }

}