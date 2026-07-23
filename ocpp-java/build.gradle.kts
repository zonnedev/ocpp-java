plugins {
    `java-library`
    id("com.vanniktech.maven.publish") version "0.37.0"
}

java {
    toolchain { languageVersion = JavaLanguageVersion.of(25) }
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    api("org.jspecify:jspecify:1.0.0")
    api("com.fasterxml.jackson.core:jackson-databind:2.19.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.19.2")
    implementation("com.networknt:json-schema-validator:1.5.8")

    testImplementation(platform("org.junit:junit-bom:5.13.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.27.3")
}


tasks.compileJava {
    options.compilerArgs.addAll(listOf("-Xlint:all", "-Werror", "-parameters"))
}

tasks.test { useJUnitPlatform() }

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates(
        groupId = "io.github.zonnedev",
        artifactId = "ocpp-java",
        version = project.version.toString(),
    )

    pom {
        name.set("OCPP Java")
        description.set(
            "Java 25 library for OCPP 1.6 JSON and OCPP 2.0.1, providing strongly typed protocol models, strict JSON encoding and decoding, and DataTransfer extension support.",
        )
        inceptionYear.set("2026")
        url.set("https://github.com/zonnedev/ocpp-java")

        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/license/mit")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("zonnedev")
                name.set("zonnedev")
                email.set("zonnedev@gmail.com")
                url.set("https://github.com/zonnedev")
            }
        }

        scm {
            url.set("https://github.com/zonnedev/ocpp-java")
            connection.set("scm:git:https://github.com/zonnedev/ocpp-java.git")
            developerConnection.set("scm:git:ssh://git@github.com/zonnedev/ocpp-java.git")
        }
    }
}
