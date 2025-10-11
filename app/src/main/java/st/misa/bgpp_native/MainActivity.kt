@file:OptIn(ExperimentalMaterial3Api::class)

package st.misa.bgpp_native

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import st.misa.bgpp_native.bgpp.presentation.search.SearchScreen
import st.misa.bgpp_native.bgpp.presentation.search.components.StationListPreview
import st.misa.bgpp_native.ui.theme.BGPPTheme
import st.misa.bgpp_native.ui.theme.BitcountFont

// Data model
data class Arrival(
    val line: String,
    val etaMinutes: Int,
    val etaStations: Int,
    val destination: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BGPPTheme {
                SearchScreen()
            }
        }
    }
}

@Composable
fun ArrivalScreen() {
    val arrivals = remember {
        listOf(
            Arrival("69", 5, 3, "SREMSKA KAMENICA (ČARDAK)"),
            Arrival("61", 12, 3, "SREMSKI KARLOVCI (VINOGRADARSKA)"),
            Arrival("9", 14, 7, "PETROVARADIN"),
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Žarka Zrenjanina-Izvršno veće") }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(arrivals) { arrival ->
                ArrivalCard(arrival)
            }
        }
    }
}

@Composable
fun ArrivalCard(arrival: Arrival) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Line ${arrival.line}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = arrival.destination,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis

                )
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${arrival.etaMinutes} min",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontFamily = BitcountFont
                    )
                )
                Text(
                    text = "${arrival.etaStations} stations",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = BitcountFont
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArrivalScreen() {
    BGPPTheme {
        ArrivalScreen()
    }
}
