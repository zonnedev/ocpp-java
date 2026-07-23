# Schema provenance and licensing

The JSON Schema files under the adjacent `v16` and `v201` directories are unmodified copies from the schema distribution in the Mobility House `ocpp` project, downloaded from its public `master` branch on 2026-07-22. That project identifies these files as originating from the Open Charge Alliance specifications.

- Redistribution source: `https://github.com/mobilityhouse/ocpp`
- OCPP 1.6 inventory: 78 files / 39 request-response action pairs, including the OCPP 1.6 security extensions present in that distribution.
- OCPP 2.0.1 inventory: 128 files / 64 request-response action pairs.
- Official publisher: Open Charge Alliance, `https://openchargealliance.org/protocols/open-charge-point-protocol/`

The schema documents are copyright Open Charge Alliance. The redistribution source states that the OCPP schemas are made available under the Creative Commons Attribution-NoDerivatives 4.0 International Public License. No protocol semantics are changed by this project. The Java model source is maintained by this project and must not be represented as an official OCA publication.

The official OCA download may require registration. Users requiring a separately obtained authoritative archive should replace the files with the corresponding OCA distribution and run the inventory, checksum, and reproducibility checks.

The schemas are retained as read-only reference material. Java model changes are made manually and reviewed like all other library code.

## OCPP 1.6 ISO 15118 DataTransfer extension

The built-in `Ocpp16Iso15118DataTransferModule` is based on “OCPP 1.6 - ISO 15118 Extension”, version 1.3, published by has-to-be gmbh on 2019-10-29.

- Source: `https://has-to-be.com/wp-content/uploads/2019/11/OCPP-1.6_v1.3-ISO-15118-extension-1.pdf`
- Inspected on: 2026-07-23
- PDF SHA-256: `7e97db8aa40e1b8ac8e1a981f1f5ce96261cfdd85fd90db92fa3d81a89702018`
- Implemented operations: Authorize, CertificateSigned, DeleteCertificate, Get15118EVCertificate, GetCertificateStatus, GetInstalledCertificateIds, InstallCertificate, SignCertificate, and ExtendedTriggerMessage.
- Explicitly omitted by the source document: Update15118EVCertificate.

The PDF is not redistributed by this project. Its copyright remains with its publisher. The implementation preserves the v1.3 vendor ID (`iso15118`), message IDs, JSON property names, stated constraints, and the textual JSON encapsulation required by OCPP 1.6 DataTransfer.
