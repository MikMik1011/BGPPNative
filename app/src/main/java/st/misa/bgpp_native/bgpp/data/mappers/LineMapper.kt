package st.misa.bgpp_native.bgpp.data.mappers

import st.misa.bgpp_native.bgpp.data.networking.dto.LineRemoteDto
import st.misa.bgpp_native.bgpp.domain.model.Line

fun LineRemoteDto.toLine() : Line {
    return Line(
        id = this.id,
        name = this.name,
        arrivals = this.arrivals.map { arrival ->
            arrival.toArrival()
        }
    )
}