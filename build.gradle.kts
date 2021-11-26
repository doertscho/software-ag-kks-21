import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
    id("org.openjfx.javafxplugin") version "0.0.9"
}

group = "me.sroepstorff"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

javafx {
    modules("javafx.controls", "javafx.graphics")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("no.tornado", "tornadofx", "1.7.20")
    runtimeOnly("org.openjfx", "javafx-plugin", "0.0.9")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}