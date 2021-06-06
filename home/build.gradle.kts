import com.plugins.*

plugins {
    id("com.android.library")
    id("common-binary-plugin")
}

dependencies {
    addNavigationDependencies()
    addCoroutineDependencies()
    addDaggerDependencies()
    addViewModelAndLiveDataDependencies()
    addRetrofitAndOkHttpDependencies()
    implementation(project(":base"))
    implementation(project(":models"))
    implementation(project(":datastore"))
}

