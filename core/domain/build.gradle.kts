plugins {
    alias(libs.plugins.com.example.android.library)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.domain"
}

dependencies {
    implementation(libs.hilt.android)

    ksp(libs.hilt.compiler)
}
