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
        const val room = "2.3.0"
        const val navigation = "2.3.5"
        const val navigationCompose = "2.4.0-alpha01"
        const val retrofit = "2.9.0"
        const val gson = "2.8.7"
        const val okHttp ="4.9.0"
        const val rxjava = "3.0.13"
        const val rxjavaAdapter = "3.0.0"

        /* test */
        const val junit = "4.12"
        const val junitExn = "1.1.2"
        const val expressoCore = "3.3.0"
        const val roboletric = "4.5.1"
        const val mockito = "1.10.19"

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
        const val room = "androidx.room:room-testing:${Versions.room}"
        const val navigation = "androidx.navigation:navigation-testing:${Versions.navigation}"
        const val mockito = "org.mockito:mockito-all:${Versions.mockito}"
        const val testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

    }

    object Core {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.jetPack}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.jetPack}"
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val roomAnnotationProcessor = "androidx.room:room-compiler:${Versions.room}"
        const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    }

    object Network {
        const val okhttp ="com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
        const val rxjava = "io.reactivex.rxjava3:rxjava:${Versions.rxjava}"
        const val rxJavaAdapter = "com.github.akarnokd:rxjava3-retrofit-adapter:${Versions.rxjavaAdapter}"
        const val reactiveRx = "io.reactivex.rxjava3:rxjava:${Versions.rxjava}"
    }

    object Dagger {
        const val dagger = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"
    }
}