object Gradle {
    const val ANDROID_GRADLE_VERSION = "3.5.0"

    object Plugins {
        const val ANDROID_APPLICATION = "com.android.application"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    }

    object Dependency {
        const val ANDROID_GRADLE = "com.android.tools.build:gradle:$ANDROID_GRADLE_VERSION"
        const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Deps.KOTLIN}"
    }
}
