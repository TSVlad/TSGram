plugins {
    kotlin("js") version "1.7.21"
}

group = "ru.tsvlad.tsgram"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.9.3-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:6.3.0-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:4.1.2-pre.346")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:7.2.6-pre.346")

    implementation("org.hildan.krossbow:krossbow-stomp-core:4.4.0")
    implementation("org.hildan.krossbow:krossbow-websocket-sockjs:4.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}