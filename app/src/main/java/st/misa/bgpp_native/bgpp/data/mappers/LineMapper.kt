package st.misa.bgpp_native.bgpp.data.mappers

import st.misa.bgpp_native.bgpp.data.networking.dto.LineRemoteDto
import st.misa.bgpp_native.bgpp.domain.model.Line

fun LineRemoteDto.toLine(): Line {
    return Line(
        number = lineNumber,
        name = lineName,
        arrivals = arrivals.map { arrival -> arrival.toArrival() }
    )
}
