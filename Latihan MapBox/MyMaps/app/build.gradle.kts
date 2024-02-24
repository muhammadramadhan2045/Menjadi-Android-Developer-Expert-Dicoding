import org.jetbrains.kotlin.fir.declarations.builder.buildScript

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}


android {
    namespace = "com.example.mymaps"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mymaps"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


        buildConfigField("String", "MAPTILER_API_KEY", "\"qXoZbs0RAqQDEPaEQOJd\"")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //maptiler
    implementation("org.maplibre.gl:android-sdk:10.2.0")

    // https://mvnrepository.com/artifact/org.maplibre.gl/android-plugin-annotation-v9
    implementation("org.maplibre.gl:android-plugin-annotation-v9:2.0.2")


//    implementation("com.github.maplibre:maplibre-navigation-android:1.0.6")

    // https://mvnrepository.com/artifact/org.webjars.npm/maplibre-gl
    implementation("org.webjars.npm:maplibre-gl:3.0.0-pre.4")

    // https://mvnrepository.com/artifact/org.maplibre.gl/android-sdk-geojson
    implementation("org.maplibre.gl:android-sdk-geojson:5.9.0")


    // https://mvnrepository.com/artifact/org.maplibre.gl/android-sdk-turf
    implementation("org.maplibre.gl:android-sdk-turf:5.9.0")

    // https://mvnrepository.com/artifact/org.maplibre.gl/android-sdk-directions-models
    implementation("org.maplibre.gl:android-sdk-directions-models:5.9.0")


    // https://mvnrepository.com/artifact/org.maplibre.gl/android-sdk-services
    implementation("org.maplibre.gl:android-sdk-services:5.9.0")


    // https://mvnrepository.com/artifact/org.maplibre.gl/android-sdk-core
    implementation("org.maplibre.gl:android-sdk-core:5.9.0")



}