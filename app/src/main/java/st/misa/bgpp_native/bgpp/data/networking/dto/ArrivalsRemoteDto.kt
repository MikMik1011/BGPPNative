package st.misa.bgpp_native.bgpp.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArrivalsRemoteDto(
    val station: StationRemoteDto,
    val lines: List<LineRemoteDto>
)