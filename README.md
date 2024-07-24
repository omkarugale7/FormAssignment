Sure, here is the updated README file with the localhost URLs included:

---

# Assignment Project

## Overview

This project is an Assignment system developed using Java and Spring Boot. It includes entities such as Forms, Submissions, Fields, and FieldValues, and provides functionality to submit forms and retrieve submissions.

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

## Project Structure

- **Model Classes**
    - `Form`: Represents a form with a title and list of submissions.
    - `Submissions`: Represents a submission of a form with a list of field values.
    - `Fields`: Represents a field in a form with properties such as label, required status, field type, and value.
    - `FieldValues`: Represents the values submitted for each field in a form submission.

- **Repositories**
    - `FormRepository`: Repository for accessing `Form` entities.
    - `SubmissionsRepository`: Repository for accessing `Submissions` entities.
    - `FieldsRepository`: Repository for accessing `Fields` entities.
    - `FieldValuesRepository`: Repository for accessing `FieldValues` entities.

- **Controllers**
    - `FormSubmissionController`: Handles form submission and retrieval of submissions.

- **Test Classes**
    - `FormSubmissionControllerTest`: Unit tests for the `FormSubmissionController`.
    - `FieldsTest`: Unit tests for the `Fields` entity.
    - `FieldValuesTest`: Unit tests for the `FieldValues` entity.

## Getting Started

### Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

### Running the Tests

To run the tests, use the following command:

```bash
mvn test
```

## In-Memory Database

This project uses the H2 in-memory database for development and testing purposes. The H2 database is automatically configured and does not require any setup.

## API Endpoints

### FormSubmissionController

- **Submit a Form**
    - **URL**: `http://localhost:8080/form/{formId}/submit`
    - **Method**: POST
    - **Description**: Submits a form with the given form ID.

- **Get All Submissions for a Form**
    - **URL**: `http://localhost:8080/form/{formId}/submissions`
    - **Method**: GET
    - **Description**: Retrieves all submissions for a given form ID.

## Example Usage

### Submitting a Form

```json
POST http://localhost:8080/form/1/submit
Content-Type: application/json

{
  "fieldValues": [
    {
      "field_id_temp": 1,
      "field_value": "Sample Value"
    }
  ]
}
```

### Retrieving Submissions

```json
GET http://localhost:8080/form/1/submissions
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Feel free to adjust the content as needed for your specific project details.