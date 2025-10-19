package st.misa.bgpp_native.bgpp.presentation.models

data class StationUi(
    val id: String,
    val name: String,
    val airDistanceInMeters: Double? = null,
    val walkingDistanceInMeters: Double? = null,
    val walkingDurationInMinutes: Int? = null,
    val favorite: Boolean = false,
)
