package st.misa.bgpp_native.bgpp.data.local.dto

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "stations",
    primaryKeys = ["id", "city"],
    indices = [
        Index(value = ["lat", "lon"]),
        Index(value = ["favorite"])
    ]
)
data class StationDbDto(
    val id: String,
    val uid: Int,
    val name: String,
    val city: String,
    val lat: Double,
    val lon: Double,
    val hash: String,
    val favorite: Boolean = false
)
