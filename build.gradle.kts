import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(Gradle.Dependency.ANDROID_GRADLE)
        classpath(Gradle.Dependency.KOTLIN_GRADLE)
        classpath(Gradle.Dependency.KTLINT_GRADLE)
    }
}

plugins {
    id(Gradle.Plugins.KTLINT_GRADLE) version Gradle.KTLINT_GRADLE_VERSION
}

allprojects {
    repositories {
        google()
        jcenter()
    }

    // We want to apply ktlint at all project level because it also checks build gradle files
    plugins.apply(Gradle.Plugins.KTLINT_GRADLE)

    // Ktlint configuration for sub-projects
    ktlint {
        version.set(Deps.KTLINT)
        verbose.set(true)
        android.set(true)
        reporters.set(setOf(ReporterType.CHECKSTYLE))

        filter {
            exclude("**/generated/**")
        }
    }
}

// JVM target applied to all Kotlin tasks across all sub-projects
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir, "$rootDir/buildSrc/build")
}

task("staticCheck") {
    description = """Mimics all static checks that run on CI.
        Note that this task is intended to run locally (not on CI), because on CI we prefer to have parallel execution
        and separate reports for each check (multiple statuses eg. on github PR page).
    """.trimMargin()
    group = "verification"

    afterEvaluate {
        val linkTasks = subprojects.mapNotNull { "${it.name}:lintDebug" }
        val ktlinkTask = "ktlintCheck"
        val unitTestTasks = subprojects.mapNotNull { "${it.name}:testDebugUnitTest" }
        val dependTasks = listOf(linkTasks, ktlinkTask, unitTestTasks)
        dependsOn(dependTasks)
    }
}
