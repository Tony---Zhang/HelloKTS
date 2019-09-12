plugins {
    id(Gradle.Plugins.ANDROID_APPLICATION)
    id(Gradle.Plugins.KOTLIN_ANDROID)
    id(Gradle.Plugins.KOTLIN_ANDROID_EXTENSIONS)
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")
    defaultConfig {
        applicationId = "com.example.hellokts"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Deps.KOTLIN}")
    implementation("androidx.appcompat:appcompat:${Deps.ANDROID_X}")
    implementation("androidx.core:core-ktx:${Deps.ANDROID_X}")
    implementation("androidx.constraintlayout:constraintlayout:${Deps.CONSTRAINT_LAYOUT}")
    testImplementation("junit:junit:${Deps.Test.JUNIT}")
    androidTestImplementation("androidx.test:runner:${Deps.AndroidTest.RUNNER}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Deps.AndroidTest.ESPRESSO}")
}
