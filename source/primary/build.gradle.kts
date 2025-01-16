plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
//    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.sai.sample.primary"
    compileSdk = 35

    defaultConfig {
//        applicationId = "com.sai.sample.primary"
        minSdk = 24
        targetSdk = 35
//        versionCode = 1
//        versionName = "1.0"

        buildConfigField("String", "PRIMARY_BASE_URL", "\"https://jsonplaceholder.typicode.com/\"")

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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":navigation"))
    implementation(project(":common-ui"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Dagger-hilt
//    implementation(libs.hilt.android)
//    kapt(libs.hilt.android.compiler)
//    implementation(libs.hilt.navigation.compose)

    // Dagger
    implementation(libs.google.dagger)
    kapt(libs.google.daggerAP)

    // Retrofit
    implementation(libs.squareup.retrofit2)
    implementation (libs.squareup.okhttp)
    implementation(libs.squareup.convertergson)
    implementation(libs.squareup.adapterRxJava)

    // ViewModel Compose
    implementation(libs.androidx.viewmodel.lifecycle)

    implementation(libs.compose.navigation)
}

kapt {
    correctErrorTypes = true
}