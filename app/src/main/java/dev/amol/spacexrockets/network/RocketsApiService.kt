package dev.amol.spacexrockets.network

import dev.amol.spacexrockets.model.network.SpacexRocketDto
import dev.amol.spacexrockets.utils.Constants.ENDPOINT_ROCKETS_DATA
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RocketsApiService {

    @GET(ENDPOINT_ROCKETS_DATA)
    suspend fun getAllRocketsData():Response<List<SpacexRocketDto>>

    @GET("$ENDPOINT_ROCKETS_DATA{id}")
    suspend fun getSpecificRocketData(@Path("id") id:String):Response<SpacexRocketDto>
}