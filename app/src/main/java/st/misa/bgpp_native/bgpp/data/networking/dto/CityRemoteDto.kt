package st.misa.bgpp_native.bgpp.data.networking.dto

import kotlinx.serialization.Serializable
import st.misa.bgpp_native.core.domain.model.Coords

@Serializable
data class CityRemoteDto(
    val id: String,
    val name: String,
    val center: Coords
)
