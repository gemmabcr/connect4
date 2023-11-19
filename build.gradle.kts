plugins {
    kotlin("jvm") version "1.9.20"
    application
}

group = "org.connect4"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val mockkVersion: String by project

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("io.mockk:mockk:$mockkVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}