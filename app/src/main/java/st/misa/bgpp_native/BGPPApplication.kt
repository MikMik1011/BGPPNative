package st.misa.bgpp_native

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import st.misa.bgpp_native.di.appModule

class BGPPApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BGPPApplication)
            modules(appModule)
        }
    }
}
