import com.plugins.addDaggerDependencies
import com.plugins.addRetrofitAndOkHttpDependencies
import com.plugins.addViewModelAndLiveDataDependencies


plugins {
    id("com.android.library")
    id("common-binary-plugin")
}
android {
    buildFeatures {
        dataBinding = true
    }
}
dependencies {
    addRetrofitAndOkHttpDependencies()
    addDaggerDependencies()
    addViewModelAndLiveDataDependencies()
    implementation(com.plugins.Dependencies.Core.location)
}


