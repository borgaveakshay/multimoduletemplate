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