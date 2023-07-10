package com.lidorttol.rickandmorty.data.local

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.local.dao.CharacterDao
import com.lidorttol.rickandmorty.data.local.dao.EpisodeDao
import com.lidorttol.rickandmorty.data.local.dao.LocationDao
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterAndOriginAndLocationWithEpisodes
import com.lidorttol.rickandmorty.data.mapper.boToCompleteDbo
import com.lidorttol.rickandmorty.data.mapper.boToDbo
import com.lidorttol.rickandmorty.data.mapper.completeDboToBo
import javax.inject.Inject
import javax.inject.Singleton

interface LocalDatasource {

    suspend fun cleanDataBase()

    suspend fun getCharacters(): List<CharacterBo>?

    suspend fun getCharactersById(id: Long): CharacterBo

    suspend fun saveCharacters(remoteResponse: List<CharacterBo>?)

}

@Singleton
class LocalDatasourceImpl @Inject constructor(
    private val characterDao: CharacterDao,
    private val locationDao: LocationDao,
    private val episodeDao: EpisodeDao,
) : LocalDatasource {

     override suspend fun cleanDataBase() {
         characterDao.cleanCharacters()
         locationDao.cleanLocations()
         episodeDao.cleanEpisodes()
     }

    override suspend fun getCharacters(): List<CharacterBo>? {
        return characterDao.getCharacters().map { it.completeDboToBo() }
    }

    override suspend fun getCharactersById(id: Long): CharacterBo {
        return characterDao.getCharacterById(id).completeDboToBo()
    }

    override suspend fun saveCharacters(remoteResponse: List<CharacterBo>?) {
        remoteResponse?.map { it.boToCompleteDbo() }?.map {
            characterDao.saveCharacter(it.character)
        }
    }

}