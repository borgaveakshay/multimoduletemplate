import com.plugins.addCoroutineDependencies
import com.plugins.addDaggerDependencies
import com.plugins.addRetrofitAndOkHttpDependencies
import com.plugins.addViewModelAndLiveDataDependencies

plugins {
    id("com.android.library")
    id("common-binary-plugin")
}

dependencies {
    addCoroutineDependencies()
    addDaggerDependencies()
    addViewModelAndLiveDataDependencies()
    addRetrofitAndOkHttpDependencies()
    implementation(project(":base"))
}

