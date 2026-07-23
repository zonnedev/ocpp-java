plugins {
    `java-library`
    id("com.vanniktech.maven.publish") version "0.37.0"
    id("me.champeau.gradle.japicmp") version "0.4.6"
}

java {
    toolchain { languageVersion = JavaLanguageVersion.of(25) }
}

sourceSets.main {
    resources.srcDir(rootProject.layout.projectDirectory.dir("schemas"))
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

val apiBaseline by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
    isTransitive = true
}

dependencies {
    apiBaseline(
        "io.github.zonnedev:ocpp-java:${providers.gradleProperty("apiBaselineVersion").get()}",
    )
}

val apiBaselineArchives = apiBaseline.incoming.artifactView {
    componentFilter { identifier ->
        identifier is org.gradle.api.artifacts.component.ModuleComponentIdentifier &&
            identifier.group == "io.github.zonnedev" &&
            identifier.module == "ocpp-java"
    }
}.files

val apiCompatibilityCheck by tasks.registering(
    me.champeau.gradle.japicmp.JapicmpTask::class,
) {
    group = "verification"
    description = "Checks binary compatibility against the last released API."
    dependsOn(tasks.jar)

    oldClasspath.from(apiBaseline)
    newClasspath.from(configurations.runtimeClasspath)
    oldArchives.from(apiBaselineArchives)
    newArchives.from(tasks.jar)

    packageIncludes = listOf("io.github.zonnedev.ocpp.*")
    packageExcludes = listOf("io.github.zonnedev.ocpp.codec.internal.*")
    onlyModified = true
    onlyBinaryIncompatibleModified = true
    failOnModification = true
    ignoreMissingClasses = false
    txtOutputFile = layout.buildDirectory.file("reports/api-compatibility.txt")
    htmlOutputFile = layout.buildDirectory.file("reports/api-compatibility.html")
}

tasks.check {
    dependsOn(apiCompatibilityCheck)
}

tasks.compileJava {
    options.compilerArgs.addAll(listOf("-Xlint:all", "-Werror", "-parameters"))
}

tasks.test {
    useJUnitPlatform()
    inputs.dir(rootProject.layout.projectDirectory.dir("schemas"))
    systemProperty(
        "ocpp.schema.directory",
        rootProject.layout.projectDirectory.dir("schemas").asFile.absolutePath,
    )
}

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
