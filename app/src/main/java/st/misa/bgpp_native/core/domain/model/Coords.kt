package st.misa.bgpp_native.core.domain.model

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class Coords(private val pair: Pair<Double, Double>) {
    val lat: Double get() = pair.first
    val lon: Double get() = pair.second
    constructor(lat: Double, lon: Double) : this(lat to lon)
    fun toPair(): Pair<Double, Double> = pair
    override fun toString(): String = "Coords(lat=$lat, lon=$lon)"
}