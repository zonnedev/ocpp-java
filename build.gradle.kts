plugins {
    base
    id("com.diffplug.spotless") version "8.9.0"
}

spotless {
    java {
        target("config/formatter-example.java")
        eclipse().configFile(file("config/eclipse-java-formatter.xml"))
        trimTrailingWhitespace()
        endWithNewline()
    }
}

allprojects {
    group = "io.github.zonnedev"
    version = providers.gradleProperty("releaseVersion")
        .orElse("0.1.0-SNAPSHOT")
        .get()

    repositories {
        mavenCentral()
    }
}

val verifySchemaInventory by tasks.registering {
    group = "verification"
    description = "Verifies that the checked-in OCPP schema reference inventory is complete."
    inputs.dir(layout.projectDirectory.dir("schemas"))

    doLast {
        val v16 = fileTree("schemas/v16") { include("*.json") }.files.size
        val v201 = fileTree("schemas/v201") { include("*.json") }.files.size

        check(v16 == 78) { "Expected 78 OCPP 1.6 schemas, found $v16" }
        check(v201 == 128) { "Expected 128 OCPP 2.0.1 schemas, found $v201" }
    }
}

tasks.check {
    dependsOn(verifySchemaInventory)
}

subprojects {
    plugins.withId("java") {
        apply(plugin = "com.diffplug.spotless")
        apply(plugin = "checkstyle")

        configure<CheckstyleExtension> {
            toolVersion = "13.8.0"
            configFile = rootProject.file("config/checkstyle/checkstyle.xml")
            isIgnoreFailures = false
            maxWarnings = 0
        }

        tasks.withType<Checkstyle>().configureEach {
            exclude("module-info.java")
        }

        configure<com.diffplug.gradle.spotless.SpotlessExtension> {
            java {
                target("src/**/*.java")
                eclipse().configFile(rootProject.file("config/eclipse-java-formatter.xml"))
                removeUnusedImports()
                forbidWildcardImports()
                trimTrailingWhitespace()
                endWithNewline()
            }
        }
    }
}
