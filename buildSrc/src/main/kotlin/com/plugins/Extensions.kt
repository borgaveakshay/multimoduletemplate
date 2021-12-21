package com.plugins

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.addCoroutineDependencies() {
    dependencies {
        add("implementation", Dependencies.Coroutines.coroutines)
        add("implementation", Dependencies.Coroutines.coroutineCore)
    }
}

fun Project.addDaggerDependencies() {
    dependencies {
        add("implementation", Dependencies.Dagger.dagger)
        add("annotationProcessor", Dependencies.Dagger.daggerCompiler)
        add("androidTestImplementation", Dependencies.TestLibs.instrumentationTestDagger)
        add(
            "androidTestAnnotationProcessor",
            Dependencies.TestLibs.instrumentationTestCompilerDagger
        )
        add("testImplementation", Dependencies.TestLibs.unitTestDagger)
        add("testAnnotationProcessor", Dependencies.TestLibs.unitTestCompilerDagger)
    }
}

fun Project.addViewModelAndLiveDataDependencies() {
    dependencies {
        add("implementation", Dependencies.Core.viewModel)
        add("implementation", Dependencies.Core.liveData)
    }
}

fun Project.addComposeDependencies() {
    dependencies {
        add("androidTestImplementation", Dependencies.Compose.test)
        add("implementation", Dependencies.Compose.composeUi)
        add("implementation", Dependencies.Compose.foundation)
        add("implementation", Dependencies.Compose.toolingSupport)
        add("implementation", Dependencies.Compose.toolingSupport)
        add("implementation", Dependencies.Compose.materialDesign)
        add("implementation", Dependencies.Compose.materialDesignIcons)
        add("implementation", Dependencies.Compose.iconExtended)
        add("implementation", Dependencies.Compose.composeActivity)
        add("implementation", Dependencies.Compose.composeViewModel)
        add("implementation", Dependencies.Compose.composeLiveData)
    }
}

fun Project.addNavigationDependencies() {
    dependencies {
        add("implementation", Dependencies.Navigation.featureModuleSupport)
        add("implementation", Dependencies.Navigation.navigationCompose)
        add("implementation", Dependencies.Navigation.navigationFragment)
        add("implementation", Dependencies.Navigation.navigationUI)
        add("androidTestImplementation", Dependencies.Navigation.test)

    }
}