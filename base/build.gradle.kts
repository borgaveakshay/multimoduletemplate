import com.plugins.addDaggerDependencies
import com.plugins.addRetrofitAndOkHttpDependencies

plugins {
    id("com.android.library")
    id("common-binary-plugin")
}
dependencies {
    addRetrofitAndOkHttpDependencies()
    addDaggerDependencies()
}


