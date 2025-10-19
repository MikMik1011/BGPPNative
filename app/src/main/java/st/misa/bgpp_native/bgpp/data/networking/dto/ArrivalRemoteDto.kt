package st.misa.bgpp_native.bgpp.data.networking.dto

import kotlinx.serialization.Serializable
import st.misa.bgpp_native.core.domain.model.Coords

@Serializable
data class ArrivalRemoteDto(
    val etaSeconds: Int,
    val etaStations: Int,
    val garageNo: String,
    val coords: Coords
) {
    override fun toString(): String {
        return "Arrival(etaSeconds=$etaSeconds, etaStations=$etaStations, garageNo='$garageNo', coords=$coords)"
    }
}
