import com.plugins.addRoomDependencies

plugins {
    id("com.android.application")
    id("common-binary-plugin")
}
dependencies {
    implementation(project(":base"))
    implementation(project(":models"))
    addRoomDependencies()
}