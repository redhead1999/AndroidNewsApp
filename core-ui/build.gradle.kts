val kotlin_version: String by extra
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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

    // AndroidX
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.material)

    // Test
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.espresso)
    implementation("androidx.core:core-ktx:+")
    implementation(kotlinModule("stdlib-jdk7", kotlin_version))
}