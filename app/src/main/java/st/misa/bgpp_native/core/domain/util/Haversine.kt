package st.misa.bgpp_native.core.domain.util

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import st.misa.bgpp_native.core.domain.model.Coords

private const val EARTH_RADIUS_METERS = 6371000.0

fun haversineDistanceInMeters(origin: Coords, destination: Coords): Double {
    val lat1 = Math.toRadians(origin.lat)
    val lat2 = Math.toRadians(destination.lat)
    val deltaLat = Math.toRadians(destination.lat - origin.lat)
    val deltaLon = Math.toRadians(destination.lon - origin.lon)

    val a = sin(deltaLat / 2).pow2() + cos(lat1) * cos(lat2) * sin(deltaLon / 2).pow2()
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    return EARTH_RADIUS_METERS * c
}

private fun Double.pow2(): Double = this * this
