package st.misa.bgpp_native.core.domain.util

import androidx.annotation.StringRes

fun interface StringProvider {
    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String
}
