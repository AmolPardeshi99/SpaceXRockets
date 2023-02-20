package dev.amol.spacexrockets.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dev.amol.spacexrockets.model.network.SpacexRocketDto

@Entity(tableName = "rocket")
@TypeConverters(Converters::class)
data class Rocket(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val country: String,
    val engineCount: Int,
    val flickrImages: List<String>,
    val activeStatus: Boolean,
    val costPerLaunch: Int,
    val successRatePct: Int,
    val description: String,
    val wikipedia: String,
    val diameter: Double,
    val height: Double
)

fun convertToRocketList(spacexRockets: List<SpacexRocketDto>): List<Rocket> {
    return spacexRockets.map { spacexRocket ->
        Rocket(
            id = spacexRocket.id,
            name = spacexRocket.name,
            country = spacexRocket.country,
            engineCount = spacexRocket.engines.number,
            flickrImages = spacexRocket.flickrImages,
            activeStatus = spacexRocket.active,
            costPerLaunch = spacexRocket.costPerLaunch,
            successRatePct = spacexRocket.successRatePct,
            description = spacexRocket.description,
            wikipedia = spacexRocket.wikipedia,
            height = spacexRocket.height.feet,
            diameter = spacexRocket.diameter.feet,
        )
    }
}

fun convertToRocketDataClass(spacexRocket: SpacexRocketDto): Rocket {
        return Rocket(
            id = spacexRocket.id,
            name = spacexRocket.name,
            country = spacexRocket.country,
            engineCount = spacexRocket.engines.number,
            flickrImages = spacexRocket.flickrImages,
            activeStatus = spacexRocket.active,
            costPerLaunch = spacexRocket.costPerLaunch,
            successRatePct = spacexRocket.successRatePct,
            description = spacexRocket.description,
            wikipedia = spacexRocket.wikipedia,
            height = spacexRocket.height.feet,
            diameter = spacexRocket.diameter.feet,
        )
}



