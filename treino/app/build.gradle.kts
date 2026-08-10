plugins {
    id("java")
    id("application")
}

group = "br.edu.fatecpg.treino"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass = "br.edu.fatecpg.treino.view.Main"
}

tasks.test {
    useJUnitPlatform()
}
