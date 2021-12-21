import com.plugins.*

plugins {
    id("com.android.library")
    id("common-binary-plugin")
}
addCoroutineDependencies()
addDaggerDependencies()
addViewModelAndLiveDataDependencies()
addComposeDependencies()
addNavigationDependencies()

