# Releasing

The library is published to Maven Central as:

```text
io.github.zonnedev:ocpp-java:<version>
```

The repository, Gradle project, and Maven artifact all use the name `ocpp-java`.

## Prerequisites

1. Sign in to the Maven Central Portal with the `zonnedev` GitHub account and confirm that
   the automatically verified `io.github.zonnedev` namespace is available.
2. Generate a Maven Central Portal user token.
3. Create a GPG key, publish its public key, and retain its armored private key.

Create a protected GitHub environment named `maven-central` and add these environment secrets:

```text
MAVEN_CENTRAL_USERNAME
MAVEN_CENTRAL_PASSWORD
SIGNING_KEY
SIGNING_PASSWORD
```

`SIGNING_KEY` must contain the ASCII-armored private key. The release workflow maps these
secrets to Gradle properties. Never commit any credential.

For local publication, supply the corresponding Gradle properties outside the repository:

```text
mavenCentralUsername
mavenCentralPassword
signingInMemoryKey
signingInMemoryKeyPassword
```

## Verify locally

Keep the version ending in `-SNAPSHOT`, then run:

```shell
./gradlew spotlessApply check publishToMavenLocal
git diff --check
```

Verify the generated POM and consume the snapshot from a separate sample project before
preparing a release.

## Publish

Releases are driven by semantic-version tags. First run the complete verification suite:

```shell
./gradlew spotlessApply check
git diff --check
```

Then create and push a signed tag:

```shell
git tag -s v0.1.0 -m "Release v0.1.0"
git push origin v0.1.0
```

The release workflow validates the tag, derives `0.1.0` as the artifact version, rebuilds
and tests the project, publishes the signed artifacts to Maven Central, and creates a GitHub
Release containing the binary, source, and Javadoc JARs. Configure required reviewers on
the `maven-central` environment if publication should require manual approval.

Maven Central releases are immutable. Fixes must be published under a new version.
