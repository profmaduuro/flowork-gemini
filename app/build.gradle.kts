plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.floworkgemini_10"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.floworkgemini_10"
        minSdk = 25
        targetSdk = 33
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
}

dependencies {


    implementation ("com.android.volley:volley:1.2.1")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation("com.google.android.material:material:1.12.0")
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}