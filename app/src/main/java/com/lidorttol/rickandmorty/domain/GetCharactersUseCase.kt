package com.lidorttol.rickandmorty.domain

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.repository.Repository
import com.lidorttol.rickandmorty.data.utils.AsyncResult
import com.lidorttol.rickandmorty.data.utils.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetCharactersUseCase {
    suspend operator fun invoke(): Flow<Event<AsyncResult<List<CharacterBo>?>>>
}

class GetCharactersUseCaseImpl @Inject constructor(private val repository: Repository) :
    GetCharactersUseCase {

    override suspend fun invoke(): Flow<Event<AsyncResult<List<CharacterBo>?>>> {
        return repository.getCharacters().flow().map { Event(it) }
    }

}