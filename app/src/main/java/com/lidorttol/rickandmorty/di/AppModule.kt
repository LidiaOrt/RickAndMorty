package com.lidorttol.rickandmorty.di

import android.content.Context
import androidx.room.Room
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.lidorttol.rickandmorty.BuildConfig
import com.lidorttol.rickandmorty.data.DATABASE_NAME
import com.lidorttol.rickandmorty.data.local.LocalDatasource
import com.lidorttol.rickandmorty.data.local.LocalDatasourceImpl
import com.lidorttol.rickandmorty.data.local.dao.CharacterDao
import com.lidorttol.rickandmorty.data.local.dao.EpisodeDao
import com.lidorttol.rickandmorty.data.local.dao.LocationDao
import com.lidorttol.rickandmorty.data.local.dao.OriginDao
import com.lidorttol.rickandmorty.data.local.database.AppDatabase
import com.lidorttol.rickandmorty.data.remote.api.ApiService
import com.lidorttol.rickandmorty.data.remote.api.RemoteDataSource
import com.lidorttol.rickandmorty.data.remote.api.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    lateinit var database: AppDatabase

    @Provides
    fun provideBaseUrl() = "https://rickandmortyapi.com/api"

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource =
        remoteDataSource

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        database = Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
        return database
    }

    @Provides
    @Singleton
    fun provideCharacterDao(database: AppDatabase): CharacterDao {
        return database.characterDao()
    }

    @Provides
    @Singleton
    fun provideLocationDao(database: AppDatabase): LocationDao {
        return database.locationDao()
    }

    @Provides
    @Singleton
    fun provideEpisodeDao(database: AppDatabase): EpisodeDao {
        return database.episodeDao()
    }

    @Provides
    @Singleton
    fun provideOriginDao(database: AppDatabase): OriginDao {
        return database.originDao()
    }

    @Provides
    @Singleton
    fun proviceLocalDatasource(
        characterDao: CharacterDao,
        locationDao: LocationDao,
        episodeDao: EpisodeDao,
        originDao: OriginDao
    ): LocalDatasource =
        LocalDatasourceImpl(
            characterDao,
            locationDao,
            episodeDao,
            originDao,
        )

}