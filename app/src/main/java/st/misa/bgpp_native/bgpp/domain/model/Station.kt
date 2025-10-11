package st.misa.bgpp_native.bgpp.domain.model

data class Station(
    val id: String,
    val uid: Int,
    val name: String,
    val coords: Coords
) {
    override fun toString(): String {
        return "Station(id='$id', uid=$uid, name='$name', coords=$coords)"
    }
}