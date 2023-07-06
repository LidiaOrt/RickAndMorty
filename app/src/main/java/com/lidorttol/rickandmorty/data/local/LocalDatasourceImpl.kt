package com.lidorttol.rickandmorty.data.local

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.local.dao.CharacterDao
import com.lidorttol.rickandmorty.data.local.dao.EpisodeDao
import com.lidorttol.rickandmorty.data.local.dao.LocationDao
import javax.inject.Inject
import javax.inject.Singleton

interface LocalDatasource {

    suspend fun cleanDataBase()

    suspend fun getCharacters(): List<CharacterBo>

    suspend fun getCharactersById(id: Int): CharacterBo

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

    override suspend fun getCharacters(): List<CharacterBo> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharactersById(id: Int): CharacterBo {
        TODO("Not yet implemented")
    }

}