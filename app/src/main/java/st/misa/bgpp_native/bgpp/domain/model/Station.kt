package st.misa.bgpp_native.bgpp.domain.model

import st.misa.bgpp_native.core.domain.model.BoundingBox
import st.misa.bgpp_native.core.domain.model.Coords

data class Station(
    val id: String,
    val uid: Int,
    val name: String,
    val coords: Coords,
    val hash: String,
    val city: City,
    val favorite: Boolean = false,
) {
    override fun toString(): String {
        return "Station(id='$id', uid=$uid, name='$name', coords=$coords)"
    }
}