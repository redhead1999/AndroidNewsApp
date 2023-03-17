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
        //consumerProguardFiles(Config.consumerProguardFiles)
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
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    // Modules
    implementation(project(":core"))

    // AndroidX
    implementation(Dependencies.AndroidX.core)

    // Room
    implementation(Dependencies.Room.library)
    kapt(Dependencies.Room.compiler)

    // Test
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.espresso)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    implementation("androidx.core:core-ktx:+")
    implementation(kotlinModule("stdlib-jdk7", kotlin_version))
}