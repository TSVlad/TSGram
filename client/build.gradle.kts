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

    implementation(npm("keycloak-js", "20.0.3"))
    implementation(npm("@react-keycloak/web", "3.4.0"))
    implementation(npm("react-bootstrap", "2.7.0"))
    implementation(npm("bootstrap", "5.2.3"))
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