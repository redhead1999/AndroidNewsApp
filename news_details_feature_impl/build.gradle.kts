import Config.consumerProguardFiles
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

val kotlin_version: String by extra

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}
apply {
    plugin("kotlin-android")
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Config.consumerProguardFiles)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                Config.consumerProguardFiles
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Modules
    implementation(project(":module-injector"))

    implementation(project(":core"))
    implementation(project(":core-db"))
    implementation(project(":core-ui"))

    implementation(project(":news_details_feature_api"))

    // AndroidX
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.material)

    // Lifecycle
    implementation(Dependencies.AndroidX.lifecycleViewModel)
    implementation(Dependencies.AndroidX.lifecycleRuntime)

    // Cicerone
    implementation(Dependencies.Cicerone.library)

    // Dagger
    implementation(Dependencies.Dagger.library)
    kapt(Dependencies.Dagger.compiler)

    // Test
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.coroutinesTest)
    androidTestImplementation(Dependencies.Test.fragmentTest)
    androidTestImplementation(Dependencies.Test.espresso)
    implementation("androidx.core:core-ktx:+")
    implementation(kotlinModule("stdlib-jdk7", kotlin_version))
}