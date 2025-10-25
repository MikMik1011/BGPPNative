package st.misa.bgpp_native.bgpp.domain.repository

import st.misa.bgpp_native.core.domain.model.BoundingBox
import st.misa.bgpp_native.bgpp.domain.model.City
import st.misa.bgpp_native.bgpp.domain.model.Station
import st.misa.bgpp_native.core.domain.model.Coords

interface StationDBRepository {
    suspend fun findStationsByQuery(city: City, query: String = ""): List<Station>
    suspend fun findNearbyStations(city: City, coords: Coords, radiusMeters: Double, limit: Int = 50): List<Station>
    suspend fun findStationsInBoundingBox(city: City, boundingBox: BoundingBox, limit: Int = 50) : List<Station>
    suspend fun findFavoriteStations(city: City): List<Station>
    suspend fun getStationById(city: City, stationId: String): Station?
    suspend fun toggleFavoriteStation(city: City, station: Station)
    suspend fun updateStations(city: City, stations: List<Station>)
    suspend fun deleteStationsForCity(city: City)
    suspend fun getCityHash(city: City): String?

    suspend fun updateCityHash(city: City, hash: String)
}
