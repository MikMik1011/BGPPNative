package st.misa.bgpp_native.core.data.resources

import android.content.Context
import androidx.annotation.StringRes
import st.misa.bgpp_native.core.domain.util.StringProvider

class AndroidStringProvider(
    private val context: Context
) : StringProvider {
    override fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
        return context.getString(resId, *formatArgs)
    }
}
