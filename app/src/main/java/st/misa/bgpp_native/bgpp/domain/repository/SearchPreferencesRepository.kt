package st.misa.bgpp_native.bgpp.domain.repository

import kotlinx.coroutines.flow.Flow
import st.misa.bgpp_native.bgpp.domain.model.SearchPreferences

interface SearchPreferencesRepository {
    val preferencesFlow: Flow<SearchPreferences>
    suspend fun getPreferences(): SearchPreferences
    suspend fun update(transform: (SearchPreferences) -> SearchPreferences)
}
