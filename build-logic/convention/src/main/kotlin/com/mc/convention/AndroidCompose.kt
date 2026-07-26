package com.mc.convention

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.configureAndroidCompose(
    libraryExtension: LibraryExtension
) {
    // Enable Compose for this Android library module
    libraryExtension.buildFeatures {
        compose = true
    }

    dependencies {
        val composeBom = libs.findLibrary("androidx-compose-bom").get()
        add("implementation", platform(composeBom))
        add("implementation", libs.findLibrary("androidx-compose-ui-tooling-preview").get())
        add("implementation", libs.findLibrary("androidx-compose-material3").get())
        add("implementation", libs.findLibrary("androidx-lifecycle-runtime-compose").get())
        add("debugImplementation", libs.findLibrary("androidx-compose-ui-tooling").get())
        add("androidTestImplementation", platform(composeBom))
    }

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            freeCompilerArgs.addAll(
                buildComposeMetricsParameters()
            )

            freeCompilerArgs.addAll(
                stabilityConfiguration()
            )
        }
    }
}

private fun Project.buildComposeMetricsParameters(): List<String> {
    val metricParameters = mutableListOf<String>()

    val enableMetricsProvider =
        providers.gradleProperty(
            "enableComposeCompilerMetrics"
        )

    val relativePath = projectDir.relativeTo(rootDir)
    val buildDir = layout.buildDirectory.get().asFile

    val enableMetrics =
        enableMetricsProvider.orNull == "true"

    if (enableMetrics) {
        val metricsFolder = buildDir
            .resolve("compose-metrics")
            .resolve(relativePath)

        metricParameters.add("-P")

        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:" +
                    "metricsDestination=${metricsFolder.absolutePath}"
        )
    }

    val enableReportsProvider =
        providers.gradleProperty(
            "enableComposeCompilerReports"
        )

    val enableReports =
        enableReportsProvider.orNull == "true"

    if (enableReports) {
        val reportsFolder = buildDir
            .resolve("compose-reports")
            .resolve(relativePath)

        metricParameters.add("-P")

        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:" +
                    "reportsDestination=${reportsFolder.absolutePath}"
        )
    }

    return metricParameters
}

private fun Project.stabilityConfiguration() = listOf(
    "-P",
    "plugin:androidx.compose.compiler.plugins.kotlin:" +
            "stabilityConfigurationPath=" +
            "${rootDir.absolutePath}/compose_compiler_config.conf"
)



