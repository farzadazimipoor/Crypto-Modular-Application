import com.android.build.gradle.LibraryExtension
import com.example.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply{
                apply("com.example.android.library")
                apply("com.example.hilt")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    //testInstrumentationRunner = "com.google.samples.apps.nowinandroid.core.testing.NiaTestRunner"
                }
            }

            dependencies {
                add("implementation", project(":core:domain"))

                add("testImplementation", kotlin("test"))
                //add("testImplementation", project(":core:testing"))
                add("androidTestImplementation", kotlin("test"))
                //add("androidTestImplementation", project(":core:testing"))

                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}