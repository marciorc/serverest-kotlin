plugins {
    kotlin("jvm") version "2.1.20"
    id("io.qameta.allure") version "2.12.0"
    id("io.qameta.allure-adapter") version "2.12.0"
}

object Versions {
    const val ALLURE = "2.29.1"
    const val JUNIT = "5.12.2"
    const val RESTASSURED = "5.5.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // Allure report
    testImplementation("io.qameta.allure:allure-junit5:${Versions.ALLURE}")
    implementation("io.qameta.allure:allure-java-commons:${Versions.ALLURE}")
    implementation("io.qameta.allure:allure-rest-assured:${Versions.ALLURE}")
    implementation("io.qameta.allure:allure-bom:${Versions.ALLURE}")

    // Gson
    implementation("com.google.code.gson:gson:2.13.1")

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT}")
    implementation("org.junit.jupiter:junit-jupiter:${Versions.JUNIT}")

    // Rest-assured
    testImplementation("io.rest-assured:rest-assured:${Versions.RESTASSURED}")
    testImplementation("io.rest-assured:json-schema-validator:${Versions.RESTASSURED}")
    testImplementation("io.rest-assured:json-path:${Versions.RESTASSURED}")
    implementation("io.rest-assured:kotlin-extensions:${Versions.RESTASSURED}")

    // slf4j
    implementation("org.slf4j:slf4j-api:2.0.17")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain (21)
}