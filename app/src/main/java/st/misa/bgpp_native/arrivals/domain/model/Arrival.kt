package st.misa.bgpp_native.arrivals.domain.model

import st.misa.bgpp_native.core.domain.model.Coords

data class Arrival(
    val etaSeconds: Int,
    val etaStations: Int,
    val garageNo: String,
    val coords: Coords
) {
    override fun toString(): String {
        return "Arrival(etaSeconds=$etaSeconds, etaStations=$etaStations, garageNo='$garageNo', coords=$coords)"
    }
}
