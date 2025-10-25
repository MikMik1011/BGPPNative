package st.misa.bgpp_native.bgpp.presentation.arrivals

internal fun formatLineDisplayName(rawName: String): String {
    val parts = rawName
        .split("-")
        .map { it.trim() }
        .filter { it.isNotEmpty() }

    return parts.lastOrNull() ?: rawName
}
