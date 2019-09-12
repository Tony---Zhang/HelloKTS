plugins {
    id(Gradle.Plugins.ANDROID_APPLICATION)
    id(Gradle.Plugins.KOTLIN_ANDROID)
    id(Gradle.Plugins.KOTLIN_ANDROID_EXTENSIONS)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)
    defaultConfig {
        applicationId = "com.example.hellokts"
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }
    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
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
