plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)

    // Generates Hilt and Room classes
    alias(libs.plugins.ksp)

    // Enables Hilt Android integration
//    alias(libs.plugins.hilt)
    alias(libs.plugins.currencyconvertor.android.hilt)
    // Enables Room schema configuration
//    alias(libs.plugins.room)
}

android {
    namespace = "com.hashinology.currencyconvertors"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.hashinology.currencyconvertors"
        minSdk = 25
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}
/*
// Required because the Room plugin is applied
room {
    schemaDirectory("$projectDir/schemas")
}
*/

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Lifecycle support for Compose
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // hiltViewModel() for Compose
    implementation(
        libs.androidx.hilt.lifecycle.viewmodel.compose
    )

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    // WorkManager
    implementation(libs.androidx.work.runtime.ktx)

    // Hilt Worker support
    implementation(libs.androidx.hilt.work)
    ksp(libs.androidx.hilt.compiler)

    // Java API desugaring
    coreLibraryDesugaring(libs.android.desugarJdkLibs)

    implementation(project(":core:network"))

    testImplementation(libs.room.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.androidx.core.testing)

}