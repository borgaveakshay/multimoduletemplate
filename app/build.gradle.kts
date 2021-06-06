import com.plugins.addDaggerDependencies
import com.plugins.addNavigationDependencies

plugins {
    id("com.android.application")
    id("common-binary-plugin")
    id("dagger.hilt.android.plugin")
}
myOptions {
    jacoco {
        excludes(
            "**/api/entity/**",
            "**/*JsonAdapter*"
        )
    }
}
android {
    buildFeatures {
        dataBinding = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":home"))
    api(project(":base"))
    implementation(project(":models"))
    implementation(project(":datastore"))
    addNavigationDependencies()
    addDaggerDependencies()
}