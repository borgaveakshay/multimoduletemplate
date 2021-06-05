import com.plugins.addDaggerDependencies
import com.plugins.addRoomDependencies
import com.plugins.addRxJavaDependancies

plugins {
    id("com.android.library")
    id("common-binary-plugin")
}
dependencies {
    implementation(project(":base"))
    implementation(project(":models"))
    addRoomDependencies()
    addDaggerDependencies()
    addRxJavaDependancies()
}