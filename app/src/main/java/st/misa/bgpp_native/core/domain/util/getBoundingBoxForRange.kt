package st.misa.bgpp_native.core.domain.util

import st.misa.bgpp_native.core.domain.model.BoundingBox
import st.misa.bgpp_native.core.domain.model.Coords
import kotlin.math.cos

fun getBoundingBoxForRange(
    coords: Coords,
    rangeInMeters: Double
): BoundingBox {
    // Approximate radius of the Earth in meters
    val earthRadius = 6378137.0

    // Latitude: 1 degree = 111,320 meters
    val latDelta = rangeInMeters / 111320.0

    // Longitude delta calculation
    val lonDelta = rangeInMeters / (earthRadius * cos(Math.toRadians(coords.lat)) * (Math.PI / 180))

    val minLat = coords.lat - latDelta
    val maxLat = coords.lat + latDelta
    val minLon = coords.lon - lonDelta
    val maxLon = coords.lon + lonDelta

    return BoundingBox(
        minLat = minLat,
        maxLat = maxLat,
        minLon = minLon,
        maxLon = maxLon
    )
}