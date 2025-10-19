package st.misa.bgpp_native.bgpp.presentation.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import st.misa.bgpp_native.bgpp.presentation.models.StationUi
import st.misa.bgpp_native.ui.theme.BGPPTheme

@Composable
fun StationList(
    stations: List<StationUi>,
    onClick: (StationUi) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(stations, key = { it.id }) { station ->
            StationListItem(
                stationUi = station,
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant,
                thickness = 0.5.dp
            )
        }
    }
}


internal val sampleStations = listOf(
    StationUi("1", "Žarka Zrenjanina-Izvršno veće", 120.0, 123.0, 3),
    StationUi("123", "Svetozara Miletića", 450.0, 511.2, 8),
    StationUi("0401B", "Trg Slobode", 800.0, 823.4, 12),
)

@PreviewLightDark
@PreviewDynamicColors
@Composable
fun StationListPreview(modifier: Modifier = Modifier) {
    BGPPTheme {
        StationList(
            stations = sampleStations,
            onClick = { stationUi ->
                println("Clicked on station: ${stationUi.name}")
            },
            modifier = modifier
        )
    }
}
