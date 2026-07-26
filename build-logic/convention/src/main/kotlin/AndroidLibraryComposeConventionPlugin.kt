import com.android.build.api.dsl.LibraryExtension
import com.mc.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            // Applies com.android.library and your compileSdk configuration
            pluginManager.apply("currencyConvertor.android.library")

            // Required for Compose with Kotlin 2
            pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

            // Pass the Android LibraryExtension to the Compose configuration
            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
            }
        }
    }
}