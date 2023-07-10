package com.lidorttol.rickandmorty.domain

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.repository.Repository
import com.lidorttol.rickandmorty.data.utils.AsyncResult
import com.lidorttol.rickandmorty.data.utils.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetCharacterByIdUseCase {
    suspend operator fun invoke(characterId: Int): Flow<Event<AsyncResult<CharacterBo>>>
}

class GetCharacterByIdUseCaseImpl @Inject constructor(private val repository: Repository) :
    GetCharacterByIdUseCase {

    override suspend fun invoke(characterId: Int): Flow<Event<AsyncResult<CharacterBo>>> {
        return repository.getCharacterDetail(characterId).flow().map { Event(it) }
    }

}