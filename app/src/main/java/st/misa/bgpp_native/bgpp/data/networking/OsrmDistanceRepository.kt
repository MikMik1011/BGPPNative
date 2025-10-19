package st.misa.bgpp_native.bgpp.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import st.misa.bgpp_native.bgpp.data.networking.dto.OsrmRouteResponse
import st.misa.bgpp_native.bgpp.domain.model.DistanceType
import st.misa.bgpp_native.bgpp.domain.repository.DistanceError
import st.misa.bgpp_native.bgpp.domain.repository.DistanceRepository
import st.misa.bgpp_native.bgpp.domain.repository.DistanceResult
import st.misa.bgpp_native.core.data.networking.safeCall
import st.misa.bgpp_native.core.domain.model.Coords
import st.misa.bgpp_native.core.domain.util.NetworkError
import st.misa.bgpp_native.core.domain.util.Result

class OsrmDistanceRepository(
    private val httpClient: HttpClient
) : DistanceRepository {

    override suspend fun calculateDistance(
        origin: Coords,
        destination: Coords,
        distanceType: DistanceType,
        osrmBaseUrl: String
    ): Result<DistanceResult, DistanceError> {
        return when (distanceType) {
            DistanceType.AIR -> Result.Error(DistanceError.UnsupportedType)
            DistanceType.WALKING -> requestWalkingDistance(origin, destination, osrmBaseUrl)
        }
    }

    private suspend fun requestWalkingDistance(
        origin: Coords,
        destination: Coords,
        baseUrl: String
    ): Result<DistanceResult, DistanceError> {
        val sanitizedBaseUrl = baseUrl.ifBlank { DEFAULT_OSRM_BASE_URL }.trimEnd('/')
        val url = "$sanitizedBaseUrl/route/v1/walking/${origin.lon},${origin.lat};${destination.lon},${destination.lat}?overview=false&alternatives=false&steps=false"

        return when (val result = safeCall<OsrmRouteResponse> { httpClient.get(url) }) {
            is Result.Error -> mapNetworkError(result.error)
            is Result.Success -> {
                val route = result.data.routes.firstOrNull()
                    ?: return Result.Error(DistanceError.NoRoute)

                Result.Success(
                    DistanceResult(
                        distanceMeters = route.distance,
                        durationSeconds = route.duration,
                        distanceType = DistanceType.WALKING
                    )
                )
            }
        }
    }

    private fun mapNetworkError(error: NetworkError): Result<DistanceResult, DistanceError> =
        Result.Error(DistanceError.Network(error))

    companion object {
        private const val DEFAULT_OSRM_BASE_URL = "https://router.project-osrm.org"
    }
}
