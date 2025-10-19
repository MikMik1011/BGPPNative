package st.misa.bgpp_native.bgpp.data.local

import st.misa.bgpp_native.bgpp.data.local.dao.CityHashDao
import st.misa.bgpp_native.bgpp.data.local.dao.StationDao
import st.misa.bgpp_native.bgpp.data.local.dto.CityHashDto
import st.misa.bgpp_native.bgpp.data.mappers.*
import st.misa.bgpp_native.bgpp.domain.model.*
import st.misa.bgpp_native.bgpp.domain.repository.StationDBRepository
import st.misa.bgpp_native.core.domain.model.BoundingBox
import st.misa.bgpp_native.core.domain.model.Coords
import st.misa.bgpp_native.core.domain.util.getBoundingBoxForRange

class StationDBRepositoryImpl(
    private val stationDao: StationDao,
    private val cityHashDao: CityHashDao
) : StationDBRepository {

    override suspend fun findStationsByQuery(city: City, query: String): List<Station> {
        val idResults = stationDao.searchStationsByIdPrefix(city.id, query)
        val nameResults = stationDao.searchStationsByName(city.id, query)
        return (idResults + nameResults)
            .distinctBy { it.id }
            .map { it.toStation(city) }
    }

    override suspend fun findNearbyStations(city: City, coords: Coords, radiusMeters: Double, limit: Int): List<Station> {
        val boundingBox = getBoundingBoxForRange(coords, radiusMeters)

        return stationDao.findStationsInBoundingBox(
            city.id,
            boundingBox.minLat,
            boundingBox.maxLat,
            boundingBox.minLon,
            boundingBox.maxLon,
            limit
        )
            .map { it.toStation(city) }
    }

    override suspend fun findStationsInBoundingBox(city: City, boundingBox: BoundingBox, limit: Int): List<Station> =
        stationDao.findStationsInBoundingBox(
            city.id,
            boundingBox.minLat, boundingBox.maxLat,
            boundingBox.minLon, boundingBox.maxLon,
            limit
        ).map { it.toStation(city) }

    override suspend fun findFavoriteStations(city: City): List<Station> =
        stationDao.findFavoriteStations(city.id).map { it.toStation(city) }

    override suspend fun toggleFavoriteStation(city: City, station: Station) {
        stationDao.toggleFavorite(city = city.id, stationId = station.id)
    }

    override suspend fun updateStations(city: City, stations: List<Station>) {
        val dbStations = stations.map { it.toDb() }
        stationDao.insertAndRebuild(dbStations)
    }

    override suspend fun deleteStationsForCity(city: City) {
        stationDao.deleteStationsForCity(city.id)
        cityHashDao.deleteCityHash(city.id)
    }

    override suspend fun getCityHash(city: City): String? = cityHashDao.getCityHash(city.id)

    override suspend fun updateCityHash(city: City, hash: String) {
        cityHashDao.insertOrUpdateHash(CityHashDto(city.id, hash))
    }
}
