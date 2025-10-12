package st.misa.bgpp_native.arrivals.domain.model

data class Line(
    val id: String,
    val name: String,
    val arrivals: List<Arrival>,
) {
    override fun toString(): String {
        return "Line(id='$id', name='$name', arrivals=$arrivals)"
    }
}
