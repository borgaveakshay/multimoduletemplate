package com.plugins

class Dependencies {

    object Apps {
        const val compileSdk = 32
        const val minSdk = 21
        const val targetSdk = 32
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
        const val dagger = "2.40.5"
        const val jetPack = "2.2.0"
        const val daggerViewModel = "1.0.0-alpha03"
        const val locationServices = "20.0.0"
        const val composeTooling = "1.1.1"
        const val composeActivity = "1.3.1"
        const val compose = "1.1.1"
        const val retrofit = "2.9.0"
        const val loggingInteceptor = "5.0.0-aplha.3"
        const val coreRuntime = "2.5.0"

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
        const val instrumentationTestDagger =
            "com.google.dagger:hilt-android-testing:${Versions.dagger}"
        const val instrumentationTestCompilerDagger =
            "com.google.dagger:hilt-compiler:${Versions.dagger}"
        const val unitTestDagger = "com.google.dagger:hilt-android-testing:${Versions.dagger}"
        const val unitTestCompilerDagger = "com.google.dagger:hilt-compiler:${Versions.dagger}"
        const val roboletric = "org.robolectric:robolectric:${Versions.roboletric}"

    }

    object Core {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.jetPack}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.jetPack}"
        const val locationServices =
            "com.google.android.gms:play-services-location:${Versions.locationServices}"
        const val coreRuntime = "'androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coreRuntime}"
    }

    object Dagger {
        const val dagger = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val daggerAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"
        const val daggerViewModel =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.daggerViewModel}"
    }

    object Compose {
        const val compose = "androidx.activity:activity-compose:${Versions.composeActivity}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.composeTooling}"
        const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInteceptor}"
    }
}