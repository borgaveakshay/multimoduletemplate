// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.32")
    val hilt = "2.36"
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hilt")
    }
}


allprojects {
    repositories {
        google()
        jcenter()
    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}