import com.plugins.addCoroutineDependencies
import com.plugins.addDaggerDependencies
import com.plugins.addViewModelAndLiveDataDependencies

plugins {
    id("com.android.library")
    id("common-binary-plugin")
}
addCoroutineDependencies()
addDaggerDependencies()
addViewModelAndLiveDataDependencies()

