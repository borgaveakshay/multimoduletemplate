package com.plugins

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonBinaryPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins.apply("kotlin-android")
            plugins.apply("kotlin-kapt")
            plugins.apply("org.jetbrains.kotlin.android")

            project.extensions.create<MyModuleExtension>("myOptions")
            val androidExtensions = project.extensions.getByName("android")
            if (androidExtensions is BaseExtension) {
                androidExtensions.apply {
                    defaultConfig {
                        minSdk = Dependencies.Apps.minSdk
                        targetSdk = Dependencies.Apps.targetSdk
                        setCompileSdkVersion(Dependencies.Apps.compileSdk)
                        versionCode = Dependencies.Apps.versionCode
                        versionName = Dependencies.Apps.versionName
                        multiDexEnabled = true

                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    }

                    // Configure common proguard file settings.
                    val proguardFile = "proguard-rules.pro"
                    when (this) {
                        is LibraryExtension -> defaultConfig {
                            consumerProguardFiles(proguardFile)
                        }
                        is AppExtension -> buildTypes {
                            getByName("release") {
                                isMinifyEnabled = true
                                isShrinkResources = true
                                proguardFiles(
                                    getDefaultProguardFile("proguard-android-optimize.txt"),
                                    proguardFile
                                )
                            }
                        }
                    }
                    // Java 8
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_1_8
                        targetCompatibility = JavaVersion.VERSION_1_8
                    }
                    project.tasks.withType(KotlinCompile::class.java).configureEach {
                        kotlinOptions {
                            jvmTarget = "1.8"
                        }
                    }
                }
            }
            defaultDependencies(project)
        }
    }

    private fun defaultDependencies(project: Project) {
        project.dependencies {

            add("implementation", Dependencies.Libs.kotlin)
            add("implementation", Dependencies.Libs.appcompat)
            add("implementation", Dependencies.Libs.materialDesign)
            add("testImplementation", Dependencies.TestLibs.junit)
            add("androidTestImplementation", Dependencies.TestLibs.testExtn)
            add("androidTestImplementation", Dependencies.TestLibs.testExtn)


        }
    }
//    private fun setUpJaccoco(project: Project){
//        // Read MyModuleExtension values in afterEvaluate block.
//        project.afterEvaluate {
//            project.extensions.getByType(MyModuleExtension::closureOf).run {
//                val jacocoOptions = this.jacoco
//                if (jacocoOptions.isEnabled) {
//                    // Setup jacoco tasks to generate coverage report for this module.
//                    project.plugins.apply(JacocoPlugin::class.java)
//                    project.plugins.all {
//                        when (this) {
//                            is LibraryPlugin -> {
//                                project.extensions.getByType(LibraryExtension::class.java).run {
//                                    configureJacoco(project, libraryVariants, jacocoOptions)
//                                }
//                            }
//                            is AppPlugin -> {
//                                project.extensions.getByType(AppExtension::class.java).run {
//                                    configureJacoco(project, applicationVariants, jacocoOptions)
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private fun configureJacoco(
//        project: Project,
//        variants: DomainObjectSet<out BaseVariant>,
//        options: JacocoOptions
//    ) {
//        variants.all {
//            val variantName = name
//            val isDebuggable = this.buildType.isDebuggable
//            if (!isDebuggable) {
//                project.logger.info("Skipping Jacoco for $name because it is not debuggable.")
//                return@all
//            }
//
//            project.tasks.register<JacocoReport>("jacoco${variantName.capitalize()}Report") {
//                val javaClasses = project
//                    .fileTree("${project.buildDir}/intermediates/javac/$variantName") {
//                        setExcludes(options.excludes)
//                    }
//
//                val kotlinClasses = project
//                    .fileTree("${project.buildDir}/tmp/kotlin-classes/$variantName") {
//                        setExcludes(options.excludes)
//                    }
//            }
//        }
//    }
}
