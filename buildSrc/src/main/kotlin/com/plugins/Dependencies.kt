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
        const val compose ="1.0.5"
        const val composeActivity = "1.3.1"
        const val composeViewModel = "1.0.0-alpha07"
        const val navigation = "2.3.5"
        const val navigationCompose = "2.4.0-rc01"


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

    object Coroutines {
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object Core {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.jetPack}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.jetPack}"
    }

    object Compose {

        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        // Tooling support (Previews, etc.)
        const val toolingSupport = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
        // Material Design
        const val materialDesign = "androidx.compose.material:material:${Versions.compose}"
        // Material design icons
        const val materialDesignIcons = "androidx.compose.material:material-icons-core:${Versions.compose}"
         const val iconExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
        // Integration with activities
        const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
        // Integration with ViewModels
        const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
        // Integration with observables
        const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
        //implementation 'androidx.compose.runtime:runtime-rxjava2:1.0.5'

        // UI Tests
        const val test = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    }

    object Navigation {

        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val featureModuleSupport = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
        const val test = "androidx.navigation:navigation-testing:${Versions.navigation}"
        const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"

    }

    object Dagger {
        const val dagger = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"

    }
}