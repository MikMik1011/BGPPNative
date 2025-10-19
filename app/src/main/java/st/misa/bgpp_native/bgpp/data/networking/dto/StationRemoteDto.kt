package st.misa.bgpp_native.bgpp.data.networking.dto

import kotlinx.serialization.Serializable
import st.misa.bgpp_native.core.domain.model.Coords

@Serializable
data class StationRemoteDto(
    val id: String,
    val uid: Int,
    val name: String,
    val coords: Coords,
    val hash: String,
) {
    override fun toString(): String {
        return "Station(id='$id', uid=$uid, name='$name', coords=$coords)"
    }
}