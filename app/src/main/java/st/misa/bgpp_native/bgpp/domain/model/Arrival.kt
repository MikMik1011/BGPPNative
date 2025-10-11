package st.misa.bgpp_native.bgpp.domain.model

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
