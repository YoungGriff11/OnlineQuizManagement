# OnlineQuizManagement
This project is a Jakarta EE-based Online Quiz Management System, designed to create, manage, and evaluate quizzes through a RESTful API. It provides secure API access, quiz storage, and automatic scoring.

Features
Quiz Creation & Management: Allows users to create quizzes with multiple-choice questions.
RESTful API: Supports adding, retrieving, updating, and deleting quizzes.
Secure API Access: Uses API key authentication for protected endpoints.
Quiz Submission & Scoring: Users can submit answers and receive scores based on correctness.

Technologies Used
Java (Jakarta EE)
JAX-RS (Jakarta RESTful Web Services)
GlassFish Server
Postman (for API testing)

Project Structure

├── src/main/java/conorgriffin/onlinequizmanagement/
│   ├── filter/               # API Key authentication filter
│   ├── model/                # Data models for quizzes and questions
│   ├── resources/            # RESTful endpoints for quiz operations
│   ├── service/              # Business logic handling quiz management
│   ├── JakartaRestConfiguration.java  # REST configuration

Installation & Setup
Prerequisites
Java 17 or later
GlassFish Server
Postman

Steps to Run the Project
Clone the repository:

git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name

Deploy the application on GlassFish or any Jakarta EE-compatible server.
Test API Endpoints using Postman:
Create a Quiz (POST /quizzes): Send a JSON payload with quiz details.

Get All Quizzes (GET /quizzes): Retrieve all stored quizzes.

Get Quiz by ID (GET /quizzes/{quizId}): Fetch a specific quiz.

Submit Answers (PUT /quizzes/{quizId}/submit): Submit responses and get a score.

API Authentication
The API requires an authentication key for access.
Include the header X-API-Key: teacher123 in API requests.

Example Quiz JSON Payload

{
  "quizId": "1",
  "title": "Java Basics",
  "questions": [
    {
      "questionText": "What is Java?",
      "choices": ["Programming Language", "Coffee Brand", "City in Indonesia"],
      "correctAnswer": "Programming Language"
    }
  ]
}


Author

Conor Griffin - Third-Year Computer Science Student
