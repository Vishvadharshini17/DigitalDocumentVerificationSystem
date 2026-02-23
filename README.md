# Digital Document Verification System

- A Java-based console application designed to simulate a real-world document verification workflow used by organizations such as universities, HR departments, and compliance teams.

- The system allows users to upload documents, assign verification officers, track document status, maintain audit logs, and generate verification reports.

- This project is built using Core Java (OOP concepts, Collections, Custom Exceptions) with a clean layered package structure.

## Project Objective:

The Digital Document Verification System enables organizations to:

- Register users who upload documents
- Register verification officers
- Upload and store document metadata
- Assign officers for document review
- Track verification status (PENDING, UNDER_REVIEW, VERIFIED, REJECTED)
- Maintain secure verification logs

## Tech Stack:

Language: Java
Concepts Used:

OOP (Encapsulation, Constructors, Packages)

Collections (ArrayList)

Custom Exceptions

Exception Handling

StringBuilder

## Layered Architecture:

IDE: Eclipse
Version Control: Git & GitHub

## Project Structure:
```plaintext
DigitalDocumentVerificationSystem
│
├── com.wipro.ddvs.entity
│      ├── User.java
│      ├── Officer.java
│      ├── Document.java
│      └── VerificationLog.java
│
├── com.wipro.ddvs.service
│      └── VerificationService.java
│
├── com.wipro.ddvs.util
│      ├── UserNotFoundException.java
│      ├── DocumentNotFoundException.java
│      ├── OfficerNotFoundException.java
│      └── InvalidVerificationException.java
│
└── com.wipro.ddvs.main
       └── Main.java
```

## Architecture Overview:

This project follows a clean layered architecture:

### Entity Layer:

Contains core business models:

- User

- Officer

- Document

- VerificationLog

### Service Layer:

- VerificationService

- Handles business logic

- Validates operations

- Manages document lifecycle

- Generates verification reports

### Utility Layer:

Custom exception classes ensure:

- Valid user references

- Valid document operations

- Proper status transitions

- Meaningful verification logs

### Main Layer:

Demonstrates complete workflow:

- Upload document

- Assign officer

- Add log

- Update status

- Generate final report

## Document Verification Workflow:

- User uploads document → Status = PENDING
- Officer assigned → Status = UNDER_REVIEW
- Officer adds verification log
- Status updated → VERIFIED or REJECTED
- System generates final verification report

## How to Run the Project:
- Create Java Project in Eclipse
File → New → Java Project

Project Name:

DigitalDocumentVerificationSystem
- Create Packages
- com.wipro.ddvs.entity
- com.wipro.ddvs.service
- com.wipro.ddvs.util
- com.wipro.ddvs.main
- Run Application

## Application Output:
<img width="592" height="262" alt="image" src="https://github.com/user-attachments/assets/5ed1590e-537f-4b18-8184-c3fe8013a5d8" />


## Test Scenarios Covered:

- Upload document with valid user
- Assign officer successfully
- Add verification log
- Update document status
- Generate verification report
- Handle invalid user
- Handle invalid document
- Handle duplicate assignment
- Handle invalid status transition

## Future Enhancements:

Database integration (JDBC/MySQL/Oracle)

Web-based interface (Servlet + JSP)

Enum for status instead of String

Role-based authentication

PDF verification certificate generation

REST API version using Spring Boot

## skills Demonstrated:

Core Java Development

Exception Handling

Layered Architecture Design

Business Logic Implementation

## Author:

Vishvadharshini
