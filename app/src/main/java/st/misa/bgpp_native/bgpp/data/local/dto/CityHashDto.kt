package st.misa.bgpp_native.bgpp.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_hashes")
data class CityHashDto(
    @PrimaryKey val city: String,
    val hash: String
)