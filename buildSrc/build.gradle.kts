plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        register("common-binary-plugin") {
            id = "common-binary-plugin"
            implementationClass = "com.plugins.CommonBinaryPlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}
dependencies {
    compileOnly(gradleApi())
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
    implementation("com.android.tools.build:gradle:7.1.3")
    implementation(kotlin("gradle-plugin", "1.6.0"))
    implementation(kotlin("android-extensions"))
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0")
}
