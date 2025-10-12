package st.misa.bgpp_native.search.domain.repository

import st.misa.bgpp_native.search.domain.model.City
import st.misa.bgpp_native.arrivals.domain.model.Line
import st.misa.bgpp_native.search.domain.model.Station
import st.misa.bgpp_native.core.domain.util.NetworkError
import st.misa.bgpp_native.core.domain.util.Result

interface BGPPDataRepository {
    suspend fun getAllStations(city: City): Result<List<Station>, NetworkError>
    suspend fun getLines(station: Station): Result<List<Line>, NetworkError>
}