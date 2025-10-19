package st.misa.bgpp_native.bgpp.data.local.dto

import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.FtsOptions


@Entity(
    tableName = "stations_fts"
)
@Fts4(
    contentEntity = StationDbDto::class,
    tokenizer = FtsOptions.TOKENIZER_UNICODE61,
)
data class StationFts(
    val name: String,
    val id: String,
    val city: String
)
