package st.misa.bgpp_native.search.domain.repository

import st.misa.bgpp_native.search.domain.model.City
import st.misa.bgpp_native.search.presentation.models.StationUi

interface SearchRepository {
    suspend fun searchStations(query: String, city: City, range: Int): List<StationUi>

}