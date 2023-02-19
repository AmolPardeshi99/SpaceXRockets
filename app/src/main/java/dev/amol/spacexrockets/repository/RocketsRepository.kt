package dev.amol.spacexrockets.repository

import dev.amol.spacexrockets.model.network.SpacexRocketDto
import dev.amol.spacexrockets.network.RocketsApiService
import dev.amol.spacexrockets.utils.Resource
import javax.inject.Inject

class RocketsRepository @Inject constructor(private val rocketsApiService: RocketsApiService) {

    suspend fun getAllRocketsData(): Resource<List<SpacexRocketDto>> {
        return try {
            val result = rocketsApiService.getAllRocketsData()
            if (result.isSuccessful && result.body()!=null){
                Resource.success(result.body())
            }else Resource.error("Error", null)
        }catch (e:Exception){
            Resource.error("Error Message : ${e.message}", null)
        }
    }


    suspend fun getSpecificRocketData(id:String): Resource<SpacexRocketDto> {
        return try {
            val result = rocketsApiService.getSpecificRocketData(id)
            if (result.isSuccessful && result.body()!=null){
                Resource.success(result.body())
            }else Resource.error("Error", null)
        }catch (e:Exception){
            Resource.error("Error Message : ${e.message}", null)
        }
    }
}