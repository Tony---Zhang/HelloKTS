// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    extra["kotlin_version"] = "1.3.50"
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        val kotlinVersion = rootProject.extra["kotlin_version"] as String
        classpath("com.android.tools.build:gradle:3.5.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
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
