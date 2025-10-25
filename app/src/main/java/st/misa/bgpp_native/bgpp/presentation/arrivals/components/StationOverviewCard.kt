package st.misa.bgpp_native.bgpp.presentation.arrivals.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import st.misa.bgpp_native.R

@Composable
fun StationOverviewCard(
    stationId: String,
    stationName: String,
    cityName: String,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = stationName,
                style = MaterialTheme.typography.headlineSmall
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AssistChip(
                    onClick = {},
                    label = { Text(text = stringResource(id = R.string.arrivals_station_id, stationId)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Place,
                            contentDescription = null
                        )
                    }
                )
                ElevatedAssistChip(
                    onClick = {},
                    label = { Text(text = cityName) }
                )
            }
        }
    }
}
