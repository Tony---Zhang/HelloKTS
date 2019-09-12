// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath(Gradle.Dependency.ANDROID_GRADLE)
        classpath(Gradle.Dependency.KOTLIN_GRADLE)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir, "$rootDir/buildSrc/build")
}
