package st.misa.bgpp_native.core.data.networking

const val BASE_URL = "https://next.bgpp.misa.st/api/v2/"

fun constructUrl(url: String): String {
    return when {
        url.contains(BASE_URL) -> url
        url.startsWith("/") -> BASE_URL + url.drop(1)
        else -> BASE_URL + url
    }
}