package st.misa.bgpp_native.bgpp.domain.model

data class Line(
    val number: String,
    val name: String,
    val arrivals: List<Arrival>,
) {
    override fun toString(): String {
        return "Line( number='$number', name='$name', arrivals=$arrivals)"
    }
}
