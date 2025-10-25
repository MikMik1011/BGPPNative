package st.misa.bgpp_native.bgpp.data.mappers

import st.misa.bgpp_native.bgpp.data.networking.dto.ArrivalRemoteDto
import st.misa.bgpp_native.bgpp.domain.model.Arrival

fun ArrivalRemoteDto.toArrival() : Arrival = Arrival(
    etaSeconds = etaSeconds,
    etaStations = etaStations,
    garageNo = garageNo,
    coords = coords,
    currentStationName = currentStationName
)
