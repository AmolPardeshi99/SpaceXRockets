package dev.amol.spacexrockets.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.amol.spacexrockets.model.local.Rocket

@Database(entities = [Rocket::class], version = 1)
abstract class RocketDataBase:RoomDatabase(){

    abstract fun rocketDao():RocketDao
}