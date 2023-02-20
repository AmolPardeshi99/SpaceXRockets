package dev.amol.spacexrockets.repository

import androidx.lifecycle.LiveData
import dev.amol.spacexrockets.db.RocketDao
import dev.amol.spacexrockets.model.local.Rocket
import dev.amol.spacexrockets.model.local.convertToRocketList
import dev.amol.spacexrockets.model.network.SpacexRocketDto
import dev.amol.spacexrockets.network.RocketsApiService
import dev.amol.spacexrockets.utils.Resource
import javax.inject.Inject

class RocketsRepository @Inject constructor(
    private val rocketsApiService: RocketsApiService,
    private val rocketDao: RocketDao
) {

    val rockets: LiveData<List<Rocket>> = rocketDao.getRocketData()

    suspend fun getAllRocketsData() {
        try {
            val result = rocketsApiService.getAllRocketsData()
            if (result.isSuccessful && result.body() != null) {
                result.body()?.let { rocketDao.addRocketData(convertToRocketList(it)) }
            } else Resource.error("Error", null)
        } catch (e: Exception) {
            Resource.error("Error Message : ${e.message}", null)
        }
    }


    suspend fun getSpecificRocketData(id: String): Resource<SpacexRocketDto> {
        return try {
            val result = rocketsApiService.getSpecificRocketData(id)
            if (result.isSuccessful && result.body() != null) {
                Resource.success(result.body())
            } else Resource.error("Error", null)
        } catch (e: Exception) {
            Resource.error("Error Message : ${e.message}", null)
        }
    }
}