package com.lidorttol.rickandmorty.domain

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.repository.Repository
import com.lidorttol.rickandmorty.data.utils.AsyncResult
import com.lidorttol.rickandmorty.data.utils.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetFilmsDataUseCase {
    suspend operator fun invoke(resetDatabase: Boolean = false): Flow<Event<AsyncResult<List<CharacterBo>>>>
}

class GetFilmsDataUseCaseImpl @Inject constructor(private val repository: Repository) :
    GetFilmsDataUseCase {

    override suspend fun invoke(resetDatabase: Boolean): Flow<Event<AsyncResult<List<CharacterBo>>>> {
        return repository.getCharacters(resetDatabase).flow().map { Event(it) }
    }

}