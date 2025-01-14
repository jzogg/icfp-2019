import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.40"
    id("com.diffplug.gradle.spotless") version "3.23.1"
}

group = "icfp2019"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(platform("org.junit:junit-bom:5.4.0"))

    implementation("com.google.guava:guava:28.0-jre")
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.junit.jupiter:junit-jupiter-api")
    implementation("org.junit.jupiter:junit-jupiter-engine")
}

spotless {
     kotlin {
        ktlint("0.33.0")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.allWarningsAsErrors = true
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()

    failFast = true
}

tasks.register("run", JavaExec::class) {
    classpath = sourceSets.getByName("main").runtimeClasspath

    main = "icfp2019.AppKt"
}
