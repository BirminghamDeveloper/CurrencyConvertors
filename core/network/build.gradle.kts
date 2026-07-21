plugins {
    alias(libs.plugins.currencyconvertor.android.library)
    id("kotlinx-serialization")
}

android {
    namespace = "com.mc.network"
}

dependencies{
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.retrofit.logger)
    implementation(libs.retrofit.converter.gson)

    implementation(libs.kotlin.serialization.json)

    implementation(project(":core:model"))
}