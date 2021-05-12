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
}