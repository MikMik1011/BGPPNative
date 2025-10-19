package st.misa.bgpp_native.bgpp.domain.repository

import st.misa.bgpp_native.bgpp.domain.model.City
import st.misa.bgpp_native.bgpp.domain.model.Line
import st.misa.bgpp_native.bgpp.domain.model.Station
import st.misa.bgpp_native.core.domain.util.NetworkError
import st.misa.bgpp_native.core.domain.util.Result

interface BGPPDataRepository {
    suspend fun getAllStations(city: City): Result<List<Station>, NetworkError>
    suspend fun getAllStationsHash(city: City): Result<String, NetworkError>
    suspend fun getArrivals(station: Station): Result<List<Line>, NetworkError>
    suspend fun getCities() : Result<List<City>, NetworkError>
}