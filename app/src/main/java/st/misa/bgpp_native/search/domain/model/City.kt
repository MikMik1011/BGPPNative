package st.misa.bgpp_native.search.domain.model

data class City(
    val id: String,
    val name: String,
    val stations: List<Station>,
)
