plugins {
    id("java")
    id("application")

    alias(libs.plugins.shadow)
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(libs.minestom)
    implementation(libs.logback)
}

application {
    mainClass = "com.example.ExampleServer"
}