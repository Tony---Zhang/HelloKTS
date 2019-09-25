# HelloKTS
KTS project practise

## Tech-stack
- Gradle
    - [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
- [Ktlint](https://github.com/JLLeitschuh/ktlint-gradle)

## Extra
### How to integrate with Protobuf into Android with Kotlin & KTS
I speed more than two hours to add protobuf dependence into my project, because the reference is so limited, I mired down in mud. Finally, I make my project with protobuf work.


Here are some key steps:

1. Add **protobuf gradle** in classpath
    ```
    buildscript {
        repositories {
            maven("https://plugins.gradle.org/m2/")
        }
        dependencies {
            classpath(Gradle.Dependency.PROTOBUF_GRADLE)
        }
    }
    ```

2. Import protobuf into your **app.gradle** to use `protobuf`

    ```
    import com.google.protobuf.gradle.*
    ```

3. Add **protobuf** plugin
    ```
    plugins {
        id(Gradle.Plugins.PROTOBUF)
    }
    ```

4. Add **protobuf-java** dependence
    ```
    implementation("com.google.protobuf:protobuf-java:${Deps.Protobuf.PROTO_VERSION}")
    ```
    
5. Config **protobuf** with **grpc** and **javalite** to avoid `package com.google.protobuf does not exist`

    ```
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
    ```
    
References:

1. https://github.com/JetBrains/Arend/blob/master/build.gradle.kts
2. https://github.com/google/protobuf-gradle-plugin/blob/master/examples/exampleKotlinDslProject/build.gradle.kts