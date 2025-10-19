package st.misa.bgpp_native.bgpp.presentation.search

import st.misa.bgpp_native.bgpp.domain.model.City
import st.misa.bgpp_native.bgpp.domain.model.SearchPreferences
import st.misa.bgpp_native.bgpp.presentation.models.StationUi

data class SearchUiState(
    val isLoading: Boolean = true,
    val searchQuery: String = "",
    val stations: List<StationUi> = emptyList(),
    val availableCities: List<City> = emptyList(),
    val selectedCity: City? = null,
    val preferences: SearchPreferences = SearchPreferences(),
    val isPreferencesDialogVisible: Boolean = false,
    val errorMessage: String? = null,
    val locationMessage: String? = null,
    val usingCityCenter: Boolean = false,
)
