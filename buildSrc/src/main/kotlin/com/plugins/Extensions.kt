package com.plugins

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

private const val IMPLEMENTATION = "implementation"
private const val KAPT = "kapt"
private const val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
private const val ANDROID_TEST_ANNOTATION_PROCESSOR = "androidTestAnnotationProcessor"
private const val TEST_IMPLEMENTATION = "testImplementation"
private const val TEST_ANNOTATION_PROCESSOR = "testAnnotationProcessor"

fun Project.addCoroutineDependencies() =
    dependencies {
        add(IMPLEMENTATION, Dependencies.Core.coroutines)
    }

fun Project.addCoreDependencies() =
    dependencies {
        add(IMPLEMENTATION, Dependencies.Core.coreKtx)
        add(IMPLEMENTATION, Dependencies.Core.coreRuntime)
    }

fun Project.addDaggerDependencies() =
    dependencies {
        add(IMPLEMENTATION, Dependencies.Dagger.dagger)
        add(IMPLEMENTATION, Dependencies.Dagger.daggerViewModel)
        add(KAPT, Dependencies.Dagger.daggerCompiler)
        add(KAPT, Dependencies.Dagger.daggerAndroidCompiler)
        add(ANDROID_TEST_IMPLEMENTATION, Dependencies.TestLibs.instrumentationTestDagger)
        add(
            ANDROID_TEST_ANNOTATION_PROCESSOR,
            Dependencies.TestLibs.instrumentationTestCompilerDagger
        )
        add(TEST_IMPLEMENTATION, Dependencies.TestLibs.unitTestDagger)
        add(TEST_ANNOTATION_PROCESSOR, Dependencies.TestLibs.unitTestCompilerDagger)
    }


fun Project.addViewModelAndLiveDataDependencies() =
    dependencies {
        add(IMPLEMENTATION, Dependencies.Core.viewModel)
        add(IMPLEMENTATION, Dependencies.Core.liveData)
    }


fun Project.addComposeDependencies() = dependencies {
    add(IMPLEMENTATION, Dependencies.Compose.compose)
    add(IMPLEMENTATION, Dependencies.Compose.composeTooling)
    add(IMPLEMENTATION, Dependencies.Compose.composePreview)
    add(IMPLEMENTATION, Dependencies.Compose.composeUi)
}


fun Project.addRetrofitDependencies() = dependencies {
    add(IMPLEMENTATION, Dependencies.Retrofit.retrofit)
    add(IMPLEMENTATION, Dependencies.Retrofit.retrofitGsonConverter)
    add(IMPLEMENTATION, Dependencies.Retrofit.loggingInterceptor)
}


fun Project.addLocationServiceDependencies() = dependencies {
    add(IMPLEMENTATION, Dependencies.Core.locationServices)
}
