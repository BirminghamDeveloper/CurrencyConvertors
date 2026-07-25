
import com.mc.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                apply("dagger.hilt.android.plugin")
            }
            dependencies {
                // TOML alias: hilt-android
                add(
                    "implementation",
                    libs.findLibrary("hilt.android").get()
                )

                // TOML alias: hilt-compiler
                // Compiler must use the KSP configuration
                add(
                    "ksp",
                    libs.findLibrary("hilt.compiler").get()
                )
            }
        }
    }
}