package st.misa.bgpp_native.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class BoundingBox(
    val minLat: Double,
    val maxLat: Double,
    val minLon: Double,
    val maxLon: Double
)