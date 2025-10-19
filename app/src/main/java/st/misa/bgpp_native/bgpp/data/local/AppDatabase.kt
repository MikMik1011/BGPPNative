package st.misa.bgpp_native.bgpp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import st.misa.bgpp_native.bgpp.data.local.dao.CityHashDao
import st.misa.bgpp_native.bgpp.data.local.dao.StationDao
import st.misa.bgpp_native.bgpp.data.local.dto.CityHashDto
import st.misa.bgpp_native.bgpp.data.local.dto.StationDbDto
import st.misa.bgpp_native.bgpp.data.local.dto.StationFts

@Database(
    entities = [StationDbDto::class, StationFts::class, CityHashDto::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stationDao(): StationDao
    abstract fun cityHashDao(): CityHashDao
}
