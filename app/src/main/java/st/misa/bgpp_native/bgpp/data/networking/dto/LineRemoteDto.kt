package st.misa.bgpp_native.bgpp.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class LineRemoteDto(
    val lineNumber: String,
    val lineName: String,
    val arrivals: List<ArrivalRemoteDto>,
) {
    override fun toString(): String {
        return "Line(lineNumber='$lineNumber', lineName='$lineName', arrivals=$arrivals)"
    }
}
