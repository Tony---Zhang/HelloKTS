object Gradle {
    const val ANDROID_GRADLE_VERSION = "3.5.0"
    const val KTLINT_GRADLE_VERSION = "8.2.0"
    const val PROTOBUF_GRADLE_VERSION = "0.8.10"

    object Plugins {
        const val ANDROID_APPLICATION = "com.android.application"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
        const val KTLINT_GRADLE = "org.jlleitschuh.gradle.ktlint"
        const val PROTOBUF = "com.google.protobuf"
    }

    object Dependency {
        const val ANDROID_GRADLE = "com.android.tools.build:gradle:$ANDROID_GRADLE_VERSION"
        const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Deps.KOTLIN}"
        const val KTLINT_GRADLE = "org.jlleitschuh.gradle:ktlint-gradle:$KTLINT_GRADLE_VERSION"
        const val PROTOBUF_GRADLE = "com.google.protobuf:protobuf-gradle-plugin:$PROTOBUF_GRADLE_VERSION"
    }
}
