plugins {
    java
}

group = "mx.sekura.telepathy"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.slf4j:slf4j-api:1.7.31")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.json:json:20210307")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}