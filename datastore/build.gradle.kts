import com.plugins.addRoomDependencies

plugins {
    id("com.android.library")
    id("common-binary-plugin")
}
dependencies {
    implementation(project(":base"))
    implementation(project(":models"))
    addRoomDependencies()
}