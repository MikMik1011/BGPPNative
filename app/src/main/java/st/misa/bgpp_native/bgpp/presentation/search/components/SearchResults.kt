package st.misa.bgpp_native.bgpp.presentation.search.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AssistChip
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import st.misa.bgpp_native.R
import st.misa.bgpp_native.bgpp.presentation.search.SearchUiState
import st.misa.bgpp_native.bgpp.presentation.search.components.StationList

@Composable
fun SearchResults(state: SearchUiState, onRetry: () -> Unit) {
    // Show any AssistChip about location status
    if (state.locationMessage != null) {
        AssistChip(
            onClick = {},
            leadingIcon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) },
            label = { Text(state.locationMessage) }
        )
    } else if (state.usingCityCenter) {
        AssistChip(
            onClick = {},
            leadingIcon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) },
            label = { Text(stringResource(id = R.string.search_using_city_center)) }
        )
    }

    Spacer(Modifier.height(12.dp))

    when {
        state.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        state.errorMessage != null && state.stations.isEmpty() -> {
            ErrorContent(
                message = state.errorMessage,
                onRetry = onRetry,
                modifier = Modifier.fillMaxSize()
            )
        }
        state.stations.isEmpty() -> {
            ErrorContent(
                message = stringResource(id = R.string.search_no_results),
                onRetry = onRetry,
                modifier = Modifier.fillMaxSize()
            )
        }
        else -> {
            StationList(
                stations = state.stations,
                onClick = { /* TODO */ },
            )
        }
    }
}
