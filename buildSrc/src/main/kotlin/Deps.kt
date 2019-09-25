// Versions consts that are used across libraries and Gradle plugins
object Deps {
    const val KOTLIN = "1.3.50"
    const val KTLINT = "0.34.2"
    const val ANDROID_X = "1.1.0"
    const val CONSTRAINT_LAYOUT = "1.1.3"

    object Test {
        const val JUNIT = "4.12"
    }

    object AndroidTest {
        const val ESPRESSO = "3.2.0"
        const val RUNNER = "1.2.0"
    }

    object Protobuf {
        const val PROTO_VERSION = "3.7.1"
        const val PROTO_C_GEN_JAVALITE_VERSION = "3.0.0"
        const val GRPC_VERSION = "1.20.0"

        const val PROTO_C = "com.google.protobuf:protoc:$PROTO_VERSION"

        object Plugin {
            const val GRPC = "io.grpc:protoc-gen-grpc-java:$GRPC_VERSION"
            const val JAVALITE = "com.google.protobuf:protoc-gen-javalite:$PROTO_C_GEN_JAVALITE_VERSION"
        }
    }
}
