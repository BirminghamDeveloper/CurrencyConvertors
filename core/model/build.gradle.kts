plugins {
    id("currencyConvertor.jvm.library")
    id("kotlinx-serialization")
}

dependencies {
    implementation(libs.kotlin.serialization.json)
}