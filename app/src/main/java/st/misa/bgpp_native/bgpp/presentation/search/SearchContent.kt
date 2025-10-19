package st.misa.bgpp_native.bgpp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import st.misa.bgpp_native.R
import st.misa.bgpp_native.bgpp.domain.model.SearchPreferences
import st.misa.bgpp_native.bgpp.presentation.search.components.PreferencesDialog
import st.misa.bgpp_native.bgpp.presentation.search.components.SearchInput
import st.misa.bgpp_native.bgpp.presentation.search.components.SearchResults
import st.misa.bgpp_native.bgpp.presentation.search.components.SearchTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchContent(
    state: SearchUiState,
    onQueryChange: (String) -> Unit,
    onOpenPreferences: () -> Unit,
    onClosePreferences: () -> Unit,
    onApplyPreferences: (SearchPreferences) -> Unit,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            SearchTopBar(
                cityName = state.selectedCity?.name,
                onOpenPreferences = onOpenPreferences
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Map navigation */ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_map),
                    contentDescription = stringResource(id = R.string.search_map_content_description)
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            SearchInput(query = state.searchQuery, onQueryChange = onQueryChange)
            Spacer(Modifier.height(12.dp))
            SearchResults(state = state, onRetry = onRefresh)
        }
    }

    if (state.isPreferencesDialogVisible) {
        PreferencesDialog(
            preferences = state.preferences,
            cities = state.availableCities,
            onDismiss = onClosePreferences,
            onConfirm = onApplyPreferences
        )
    }
}
