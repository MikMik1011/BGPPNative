package st.misa.bgpp_native.bgpp.domain.model

import st.misa.bgpp_native.core.domain.model.Coords

data class Arrival(
    val etaSeconds: Int,
    val etaStations: Int,
    val garageNo: String,
    val coords: Coords,
    val currentStationName: String? = null
) {
    override fun toString(): String {
        return "Arrival(etaSeconds=$etaSeconds, etaStations=$etaStations, garageNo='$garageNo', coords=$coords, currentStationName=$currentStationName)"
    }
}
