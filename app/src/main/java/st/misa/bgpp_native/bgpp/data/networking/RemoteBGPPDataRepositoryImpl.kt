package st.misa.bgpp_native.bgpp.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import st.misa.bgpp_native.bgpp.data.mappers.toCity
import st.misa.bgpp_native.bgpp.data.mappers.toLine
import st.misa.bgpp_native.bgpp.data.mappers.toStation
import st.misa.bgpp_native.bgpp.data.networking.dto.AllStationsHashRemoteDto
import st.misa.bgpp_native.bgpp.data.networking.dto.ArrivalsRemoteDto
import st.misa.bgpp_native.bgpp.data.networking.dto.CityRemoteDto
import st.misa.bgpp_native.bgpp.data.networking.dto.StationRemoteDto
import st.misa.bgpp_native.bgpp.domain.model.City
import st.misa.bgpp_native.bgpp.domain.model.Line
import st.misa.bgpp_native.bgpp.domain.model.Station
import st.misa.bgpp_native.bgpp.domain.repository.BGPPDataRepository
import st.misa.bgpp_native.core.data.networking.constructUrl
import st.misa.bgpp_native.core.data.networking.safeCall
import st.misa.bgpp_native.core.domain.util.NetworkError
import st.misa.bgpp_native.core.domain.util.Result
import st.misa.bgpp_native.core.domain.util.map

class RemoteBGPPDataRepositoryImpl (
    private val httpClient: HttpClient
) : BGPPDataRepository {
    override suspend fun getAllStations(city: City): Result<List<Station>, NetworkError> {
        return safeCall<List<StationRemoteDto>> {
            httpClient.get(urlString = constructUrl("/cities/${city.id}/stations"))
        }.map { stationDtoList ->
            stationDtoList.map { stationDto ->
                stationDto.toStation(city)
            }
        }
    }

    override suspend fun getAllStationsHash(city: City): Result<String, NetworkError> {
        return safeCall<AllStationsHashRemoteDto> {
            httpClient.get(urlString = constructUrl("/cities/${city.id}/stations/hash"))
        }.map { dto ->
            dto.hash
        }
    }

    override suspend fun getArrivals(station: Station): Result<List<Line>, NetworkError> {
        return safeCall<ArrivalsRemoteDto> {
            httpClient.get(urlString = constructUrl("/cities/${station.city.id}/stations/${station.id}/arrivals"))
        }.map { linesDto ->
            linesDto.lines.map { lineDto ->
                lineDto.toLine()
            }
        }
    }

    override suspend fun getCities(): Result<List<City>, NetworkError> {
        return safeCall<List<CityRemoteDto>> {
            httpClient.get(urlString = constructUrl("/cities"))
        }.map { cityDtoList ->
            cityDtoList.map { cityDto ->
                cityDto.toCity()
            }
        }
    }
}