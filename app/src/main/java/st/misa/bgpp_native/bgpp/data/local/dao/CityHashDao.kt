package st.misa.bgpp_native.bgpp.data.local.dao

import androidx.room.*
import st.misa.bgpp_native.bgpp.data.local.dto.CityHashDto

@Dao
interface CityHashDao {
    @Query("SELECT hash FROM city_hashes WHERE city = :city LIMIT 1")
    suspend fun getCityHash(city: String): String?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateHash(hash: CityHashDto)

    @Query("DELETE FROM city_hashes WHERE city = :city")
    suspend fun deleteCityHash(city: String)
}
