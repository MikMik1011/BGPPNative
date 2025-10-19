package st.misa.bgpp_native.bgpp.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class OsrmRouteResponse(
    val code: String,
    val routes: List<OsrmRouteDto> = emptyList()
)

@Serializable
data class OsrmRouteDto(
    val distance: Double,
    val duration: Double
)
