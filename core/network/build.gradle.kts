plugins {
    alias(libs.plugins.com.example.android.library)
    alias(libs.plugins.com.example.android.hilt)
}

android {
    namespace = "com.example.network"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.com.squareup.retrofit2)
    implementation(libs.com.squareup.retrofit2.converter.gson)
    implementation(libs.okhttp.logging)
    implementation(libs.com.google.code.gson)
}