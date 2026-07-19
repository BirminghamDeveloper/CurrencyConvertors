plugins{
    alias(libs.plugins.currencyconvertor.android.library)
}

android {
    namespace = "com.mc.network"
    compileSdk {
        version = release(36)
    }
}