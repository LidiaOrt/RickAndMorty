package com.lidorttol.rickandmorty.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lidorttol.rickandmorty.data.local.dao.CharacterDao
import com.lidorttol.rickandmorty.data.local.dao.EpisodeDao
import com.lidorttol.rickandmorty.data.local.dao.LocationDao
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterDbo
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterEpisodeCrossRef
import com.lidorttol.rickandmorty.data.local.dbo.episode.EpisodeDbo
import com.lidorttol.rickandmorty.data.local.dbo.location.LocationDbo

@Database(
    entities = [
        CharacterDbo::class,
        LocationDbo::class,
        EpisodeDbo::class,
        CharacterEpisodeCrossRef::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun locationDao(): LocationDao

    abstract fun episodeDao(): EpisodeDao

}