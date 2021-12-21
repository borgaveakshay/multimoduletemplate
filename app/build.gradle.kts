import com.plugins.addDaggerDependencies
import com.plugins.addNavigationDependencies

plugins {
    id("com.android.application")
    id("common-binary-plugin")

}
myOptions {
    jacoco {
        excludes(
            "**/api/entity/**",
            "**/*JsonAdapter*"
        )
    }
}

dependencies {

    implementation(project(":home"))
    addNavigationDependencies()
    addDaggerDependencies()

}