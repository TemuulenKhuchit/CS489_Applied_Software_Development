# ADS — Appointment Dental System (Lab 3)

A concise requirements and design summary for the Appointment Dental System used in CS489 Lab 3.

## Table of contents

- Part 1 — Requirements Discovery (Functional Requirements)
- Part 2 — Domain Model (UML Class Diagram)
- Notes & viewing instructions

---

## Part 1 — Requirements Discovery (Functional Requirements)

The system supports managing dentists, patients, appointments, and surgery locations. Below are the core functional requirements and related constraints.

### Functional requirements

1. The system must allow the Office Manager to register new Dentists with a unique ID, name, phone, email, and specialization.
2. The system must allow the Office Manager to enroll new Patients with name, phone, email, mailing address, and date of birth.
3. Patients must be able to request appointments either by phone (through the Office Manager) or via the ADS website.
4. The system must allow the Office Manager to book appointments and send confirmation emails to Patients.
5. Dentists must be able to sign in to the system.
6. Dentists must be able to view their appointments, including Patient details.
7. Patients must be able to sign in to the system.
8. Patients must be able to view their appointments, including Dentist details.
9. Patients must be able to request cancellation or changes to their appointments.
10. The system must store and provide information about Surgery locations (name, address, telephone).

### Business rules / constraints

- A Dentist cannot have more than 5 appointments per week.
- Patients with unpaid bills are prevented from booking new appointments.

---

## Part 2 — Domain Model (UML Class Diagram)

Below is the domain model for the system represented as a UML Class Diagram. It shows the main entities (Dentist, Patient, Appointment, Surgery, OfficeManager, Billing) and their relationships.

![UML Class diagram](./UML%20Class%20diagram.png)

> Caption: Domain model for ADS (Appointment Dental System) — class names and primary attributes are shown. Use this to guide implementation and database design.

---

## Notes & how to view

- To view this README nicely, open it in VS Code or on GitHub. The UML image is embedded from `./UML Class diagram.png` located in the same folder.
- If the image doesn't appear on GitHub, ensure the file name matches exactly (including spaces and case).

Last updated: 2025-10-02
