package st.misa.bgpp_native.bgpp.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class LineRemoteDto(
    val id: String,
    val name: String,
    val arrivals: List<ArrivalRemoteDto>,
) {
    override fun toString(): String {
        return "Line(id='$id', name='$name', arrivals=$arrivals)"
    }
}
