package com.lidorttol.rickandmorty.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lidorttol.rickandmorty.data.local.dao.CharacterDao
import com.lidorttol.rickandmorty.data.local.dao.EpisodeDao
import com.lidorttol.rickandmorty.data.local.dao.LocationDao
import com.lidorttol.rickandmorty.data.local.dao.OriginDao
import com.lidorttol.rickandmorty.data.local.dbo.CharacterDbo
import com.lidorttol.rickandmorty.data.local.dbo.EpisodeDbo
import com.lidorttol.rickandmorty.data.local.dbo.LocationDbo
import com.lidorttol.rickandmorty.data.local.dbo.OriginDbo

@Database(
    entities = [
        CharacterDbo::class,
        LocationDbo::class,
        OriginDbo::class,
        EpisodeDbo::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun locationDao(): LocationDao

    abstract fun episodeDao(): EpisodeDao

    abstract fun originDao(): OriginDao

}