import com.android.build.api.dsl.LibraryExtension
import convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {

            // AGP 9 already provides built in Kotlin support
            pluginManager.apply("com.android.library")

            // Configure the public AGP 9 LibraryExtension
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
            }
        }
    }
}