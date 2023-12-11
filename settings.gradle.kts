pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CryptoModularApplication"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app:composemobile")
include(":app:xmlmobile")

include(":core:domain")
include(":core:data")

include(":feature:compose-crypto")
