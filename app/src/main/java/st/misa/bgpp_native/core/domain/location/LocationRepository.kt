package st.misa.bgpp_native.core.domain.location

import st.misa.bgpp_native.core.domain.model.Coords
import st.misa.bgpp_native.core.domain.util.Result

interface LocationRepository {
    suspend fun getCurrentLocation(): Result<Coords, LocationError>
    fun hasLocationPermission(): Boolean
}

sealed interface LocationError : st.misa.bgpp_native.core.domain.util.Error {
    data object MissingPermission : LocationError
    data object ProviderDisabled : LocationError
    data object NoFix : LocationError
    data object Unknown : LocationError
}
