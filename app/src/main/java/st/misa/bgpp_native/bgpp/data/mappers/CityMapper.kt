package st.misa.bgpp_native.bgpp.data.mappers

import st.misa.bgpp_native.bgpp.data.networking.dto.CityRemoteDto
import st.misa.bgpp_native.bgpp.domain.model.City

fun CityRemoteDto.toCity() : City = City(
    id = id,
    name = name,
    center = center
)