package dev.amol.spacexrockets.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.amol.spacexrockets.model.local.Rocket

@Dao
interface RocketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRocketData(rockets: List<Rocket>)

    @Query("SELECT * from rocket")
    fun getRocketData(): LiveData<List<Rocket>>

    @Query("DELETE FROM rocket")
    suspend fun deleteAllDatabase()
}