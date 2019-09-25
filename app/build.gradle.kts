import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import com.google.protobuf.gradle.*

plugins {
    id(Gradle.Plugins.ANDROID_APPLICATION)
    id(Gradle.Plugins.KOTLIN_ANDROID)
    id(Gradle.Plugins.KOTLIN_ANDROID_EXTENSIONS)
    id(Gradle.Plugins.KTLINT_GRADLE)
    id(Gradle.Plugins.PROTOBUF)
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
    lintOptions {
        isIgnoreTestSources = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        // "this" is currently lacking a proper type
        // See: https://youtrack.jetbrains.com/issue/KT-31077
        val options = this as? KotlinJvmOptions
        options?.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    packagingOptions {
        exclude("proto/sample.proto")
    }
}

protobuf {
    protoc {
        artifact = Deps.Protobuf.PROTO_C
    }
    plugins {
        id("grpc") {
            artifact = Deps.Protobuf.Plugin.GRPC
        }
        id("javalite") {
            artifact = Deps.Protobuf.Plugin.JAVALITE
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc") {
                    option("lite")
                }
                id("javalite")
            }
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Deps.KOTLIN}")
    implementation("androidx.appcompat:appcompat:${Deps.ANDROID_X}")
    implementation("androidx.core:core-ktx:${Deps.ANDROID_X}")
    implementation("androidx.constraintlayout:constraintlayout:${Deps.CONSTRAINT_LAYOUT}")
    implementation("com.google.protobuf:protobuf-java:${Deps.Protobuf.PROTO_VERSION}")
    testImplementation("junit:junit:${Deps.Test.JUNIT}")
    androidTestImplementation("androidx.test:runner:${Deps.AndroidTest.RUNNER}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Deps.AndroidTest.ESPRESSO}")
}
