package st.misa.bgpp_native.search.presentation.models

data class StationUi(
    val id: String,
    val name: String,
    val airDistanceInMeters: Double,
    val walkingDistanceInMeters: Double? = null,
    val walkingDurationInMinutes: Int? = null
)
