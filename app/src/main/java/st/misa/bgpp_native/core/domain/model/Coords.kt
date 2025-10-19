package st.misa.bgpp_native.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Coords(
    val lat: Double,
    val lon: Double
) {

    constructor(pair: Pair<Double, Double>) : this(
        lat = pair.first,
        lon = pair.second
    )

    constructor(arr: DoubleArray) : this(
        lat = arr[0],
        lon = arr[1]
    )

    fun toPair(): Pair<Double, Double> = lat to lon
    fun toDoubleArray(): DoubleArray = doubleArrayOf(lat, lon)
}
