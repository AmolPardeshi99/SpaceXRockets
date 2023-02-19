package dev.amol.spacexrockets.model.network

import com.google.gson.annotations.SerializedName

data class SpacexRocketDto(

	@field:SerializedName("second_stage")
	val secondStage: SecondStage,

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("mass")
	val mass: Mass,

	@field:SerializedName("active")
	val active: Boolean,

	@field:SerializedName("cost_per_launch")
	val costPerLaunch: Int,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("payload_weights")
	val payloadWeights: List<PayloadWeightsItem>,

	@field:SerializedName("first_flight")
	val firstFlight: String,

	@field:SerializedName("landing_legs")
	val landingLegs: LandingLegs,

	@field:SerializedName("diameter")
	val diameter: Diameter,

	@field:SerializedName("flickr_images")
	val flickrImages: List<String>,

	@field:SerializedName("first_stage")
	val firstStage: FirstStage,

	@field:SerializedName("engines")
	val engines: Engines,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("stages")
	val stages: Int,

	@field:SerializedName("boosters")
	val boosters: Int,

	@field:SerializedName("company")
	val company: String,

	@field:SerializedName("success_rate_pct")
	val successRatePct: Int,

	@field:SerializedName("wikipedia")
	val wikipedia: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("height")
	val height: Height
)

data class CompositeFairing(

    @field:SerializedName("diameter")
    val diameter: Diameter,

    @field:SerializedName("height")
    val height: Height
)

data class Diameter(

    @field:SerializedName("feet")
    val feet: Any,

    @field:SerializedName("meters")
    val meters: Any
)

data class PayloadWeightsItem(

    @field:SerializedName("lb")
    val lb: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("kg")
    val kg: Int
)

data class ThrustVacuum(

    @field:SerializedName("lbf")
    val lbf: Int,

    @field:SerializedName("kN")
    val kN: Int
)

data class Thrust(

    @field:SerializedName("lbf")
    val lbf: Int,

    @field:SerializedName("kN")
    val kN: Int
)

data class ThrustSeaLevel(

    @field:SerializedName("lbf")
    val lbf: Int,

    @field:SerializedName("kN")
    val kN: Int
)

data class FirstStage(

    @field:SerializedName("thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevel,

    @field:SerializedName("fuel_amount_tons")
    val fuelAmountTons: Any,

    @field:SerializedName("thrust_vacuum")
    val thrustVacuum: ThrustVacuum,

    @field:SerializedName("engines")
    val engines: Int,

    @field:SerializedName("burn_time_sec")
    val burnTimeSec: Int,

    @field:SerializedName("reusable")
    val reusable: Boolean
)

data class SecondStage(

    @field:SerializedName("fuel_amount_tons")
    val fuelAmountTons: Any,

    @field:SerializedName("payloads")
    val payloads: Payloads,

    @field:SerializedName("engines")
    val engines: Int,

    @field:SerializedName("burn_time_sec")
    val burnTimeSec: Int,

    @field:SerializedName("thrust")
    val thrust: Thrust,

    @field:SerializedName("reusable")
    val reusable: Boolean
)

data class Engines(

    @field:SerializedName("layout")
    val layout: String,

    @field:SerializedName("number")
    val number: Int,

    @field:SerializedName("propellant_1")
    val propellant1: String,

    @field:SerializedName("thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevel,

    @field:SerializedName("engine_loss_max")
    val engineLossMax: Double,

    @field:SerializedName("thrust_to_weight")
    val thrustToWeight: Double,

    @field:SerializedName("thrust_vacuum")
    val thrustVacuum: ThrustVacuum,

    @field:SerializedName("isp")
    val isp: Isp,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("version")
    val version: String,

    @field:SerializedName("propellant_2")
    val propellant2: String
)

data class Isp(

    @field:SerializedName("vacuum")
    val vacuum: Double,

    @field:SerializedName("sea_level")
    val seaLevel: Double
)

data class Payloads(

    @field:SerializedName("composite_fairing")
    val compositeFairing: CompositeFairing,

    @field:SerializedName("option_1")
    val option1: String
)

data class Height(

    @field:SerializedName("feet")
    val feet: Any,

    @field:SerializedName("meters")
    val meters: Any
)

data class Mass(

    @field:SerializedName("lb")
    val lb: Int,

    @field:SerializedName("kg")
    val kg: Int
)

data class LandingLegs(

    @field:SerializedName("number")
    val number: Int,

    @field:SerializedName("material")
    val material: Any
)
