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


task("staticCheck") {
    description = """Mimics all static checks that run on CI.
        Note that this task is intended to run locally (not on CI), because on CI we prefer to have parallel execution
        and separate reports for each check (multiple statuses eg. on github PR page).
    """.trimMargin()
    group = "verification"

    afterEvaluate {
        val linkTasks = subprojects.mapNotNull { "${it.name}:lintDebug" }
        val dependTasks = listOf(linkTasks)
        dependsOn(dependTasks)
    }
}