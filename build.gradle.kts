plugins {
    kotlin("jvm") version "2.1.10"
    application
}

group = "dev.lambo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("dev.lambo.MainKt")
}

tasks.named("run", JavaExec::class) {
    standardInput = System.`in`
}
