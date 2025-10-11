package st.misa.bgpp_native.bgpp.domain.repository

import st.misa.bgpp_native.bgpp.domain.model.City
import st.misa.bgpp_native.bgpp.presentation.models.StationUi

interface SearchRepository {
    suspend fun searchStations(query: String, city: City, range: Int): List<StationUi>

}