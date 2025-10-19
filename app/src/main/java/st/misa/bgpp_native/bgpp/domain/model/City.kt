package st.misa.bgpp_native.bgpp.domain.model

import st.misa.bgpp_native.core.domain.model.Coords

data class City(
    val id: String,
    val name: String,
    val center: Coords
)
