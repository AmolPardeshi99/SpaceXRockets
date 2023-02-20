package dev.amol.spacexrockets.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.amol.spacexrockets.db.RocketDao
import dev.amol.spacexrockets.db.RocketDataBase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context:Context):RocketDataBase{
        return Room.databaseBuilder(context, RocketDataBase::class.java, "rocketDB").build()
    }

    @Singleton
    @Provides
    fun provideRocketDao(database: RocketDataBase): RocketDao {
        return database.rocketDao()
    }

}