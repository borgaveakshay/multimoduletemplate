import com.plugins.addCoroutineDependencies
import com.plugins.addDaggerDependencies
import com.plugins.addViewModelAndLiveDataDependencies

plugins {
    id("com.android.library")
    id("common-binary-plugin")
}
dependencies {
    implementation(project(":base"))
    addCoroutineDependencies()
    addDaggerDependencies()
    addViewModelAndLiveDataDependencies()
}


