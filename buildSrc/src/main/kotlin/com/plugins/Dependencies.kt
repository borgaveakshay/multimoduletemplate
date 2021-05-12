package com.plugins

class Dependencies {

    object Apps {
        const val compileSdk = 29
        const val minSdk = 21
        const val targetSdk = 29
        const val versionCode = 1
        const val versionName = "1.0.0"
    }

    object Versions {
        const val gradle = "4.1.3"
        const val kotlin = "1.4.32"
        const val appcompat = "1.2.0"
        const val coreKtx = "1.3.2"
        const val material = "1.3.0"
        const val coroutines = "1.3.9"
        const val dagger = "2.35.1"
        const val jetPack = "2.2.0"

        /* test */
        const val junit = "4.12"
        const val junitExn = "1.1.2"
        const val expressoCore = "3.3.0"
        const val roboletric = "4.5.1"

        /* build tools */
        const val gradlePlugin = "1.3.72"
    }

    object Libs {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val materialDesign = "com.google.android.material:material:${Versions.material}"
    }

    object TestLibs {
        const val junit = "junit:junit:${Versions.junit}"
        const val testExtn = "androidx.test.ext:junit:${Versions.junitExn}"
        const val expressoCore = "androidx.test.espresso:espresso-core:${Versions.expressoCore}"
        const val instrumentationTestDagger = "com.google.dagger:hilt-android-testing:${Versions.dagger}"
        const val instrumentationTestCompilerDagger = "com.google.dagger:hilt-compiler:${Versions.dagger}"
        const val unitTestDagger = "com.google.dagger:hilt-android-testing:${Versions.dagger}"
        const val unitTestCompilerDagger = "com.google.dagger:hilt-compiler:${Versions.dagger}"
        const val roboletric  = "org.robolectric:robolectric:${Versions.roboletric}"

    }

    object Core {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.jetPack}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.jetPack}"
    }

    object Dagger {
        const val dagger = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"

    }
}