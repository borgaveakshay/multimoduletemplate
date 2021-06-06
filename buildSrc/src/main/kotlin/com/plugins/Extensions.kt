package com.plugins

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.addCoroutineDependencies() {
    dependencies {
        add("implementation", Dependencies.Core.coroutines)
    }
}

fun Project.addDaggerDependencies() {
    dependencies {
        add("implementation", Dependencies.Dagger.dagger)
        add("annotationProcessor", Dependencies.Dagger.daggerCompiler)
        add("androidTestImplementation", Dependencies.TestLibs.instrumentationTestDagger)
        add("androidTestAnnotationProcessor", Dependencies.TestLibs.instrumentationTestCompilerDagger)
        add("testImplementation", Dependencies.TestLibs.unitTestDagger)
        add("testAnnotationProcessor", Dependencies.TestLibs.unitTestCompilerDagger)
    }
}

fun Project.addViewModelAndLiveDataDependencies() {
    dependencies{
        add("implementation", Dependencies.Core.viewModel)
        add("implementation", Dependencies.Core.liveData)
    }
}

fun Project.addRoomDependencies() {
    dependencies {
        add("implementation", Dependencies.Core.room)
        add("kapt", Dependencies.Core.roomAnnotationProcessor)
        add("implementation", Dependencies.Core.roomRxSupport)
        add("testImplementation", Dependencies.TestLibs.room)
    }
}

fun Project.addNavigationDependencies() {
    dependencies {
        add("implementation", Dependencies.Core.navigation)
        add("implementation", Dependencies.Core.navigationUi)
        add("androidTestImplementation", Dependencies.TestLibs.navigation)
    }
}

fun Project.addRetrofitAndOkHttpDependencies() {
    dependencies {
        add("implementation", Dependencies.Network.retrofit)
        add("implementation", Dependencies.Network.okhttp)
        add("implementation", Dependencies.Network.loggingInterceptor)
        addRxJavaDependancies()
        addGsonDependency()
    }
}

fun Project.addRxJavaDependancies() {
    dependencies {
        add("implementation", Dependencies.Network.rxjava)
        add("implementation", Dependencies.Network.rxJavaAdapter)
        add("implementation", Dependencies.Network.reactiveRx)
        add("implementation", Dependencies.Network.rxAndroid)
    }
}

fun Project.addGsonDependency() {
    dependencies {
        add("implementation", Dependencies.Network.gson)
        add("implementation", Dependencies.Network.gsonConvertor)
    }
}