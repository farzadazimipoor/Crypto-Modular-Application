plugins {
    alias(libs.plugins.com.example.android.application)
    alias(libs.plugins.com.example.android.application.compose)
    alias(libs.plugins.com.example.android.application.flavors)
    alias(libs.plugins.com.example.android.hilt)
}

android {
    defaultConfig {
        applicationId = "com.example.composemobile"
        versionCode = 1
        versionName = "1.0.0" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        // Custom test runner to set up Hilt dependency graph
        //testInstrumentationRunner = "com.google.samples.apps.nowinandroid.core.testing.NiaTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = "com.example.composemobile"
}

dependencies {

    implementation(projects.feature.composeCrypto)

    implementation(projects.core.domain)
    implementation(projects.core.data)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    androidTestImplementation(kotlin("test"))
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Core functions
    testImplementation(libs.work.testing)
    testImplementation(kotlin("test"))
    kspTest(libs.hilt.compiler)
}